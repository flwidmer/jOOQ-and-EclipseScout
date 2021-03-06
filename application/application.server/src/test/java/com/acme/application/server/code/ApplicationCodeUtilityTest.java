package com.acme.application.server.code;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.eclipse.scout.rt.shared.services.common.code.ICode;
import org.eclipse.scout.rt.testing.platform.runner.RunWithSubject;
import org.eclipse.scout.rt.testing.server.runner.RunWithServerSession;
import org.eclipse.scout.rt.testing.server.runner.ServerTestRunner;
import org.jooq.DSLContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.acme.application.database.generator.InitializerApplication;
import com.acme.application.database.table.TableDataInitializer;
import com.acme.application.group_a.shared.sv.EtageCodeType;
import com.acme.application.server.ServerSession;
import com.acme.application.shared.code.ApplicationCodeUtility;
import com.acme.application.shared.code.LocaleCodeType;
import com.acme.application.shared.code.SexCodeType;

@RunWithSubject("root")
@RunWith(ServerTestRunner.class)
@RunWithServerSession(ServerSession.class)
public class ApplicationCodeUtilityTest {

	private Connection connection = null;

	@Before
	public void setup() throws Exception {
		try (Connection jdbcConnection = InitializerApplication.getConnection()) {
			InitializerApplication.initDatabase(jdbcConnection);
			connection = jdbcConnection;
		}
	}

	@After
	public void teardown() throws SQLException {
		if(connection != null) {
			connection.close();
		}
	}

	@Test
	public void testStaticSexCodes() {
		// test exists methods
		assertTrue("Sex code type not found", ApplicationCodeUtility.exists(SexCodeType.class));
		assertTrue("Male sex code not found", ApplicationCodeUtility.exists(SexCodeType.class, TableDataInitializer.CODE_MALE.getId()));
		assertTrue("Female sex code not found", ApplicationCodeUtility.exists(SexCodeType.class, TableDataInitializer.CODE_FEMALE.getId()));

		// test get methods via code type class
		ICode<String> mCode = ApplicationCodeUtility.getCode(SexCodeType.class, TableDataInitializer.CODE_MALE.getId());
		assertNotNull("Sex code type not found", ApplicationCodeUtility.getCodeType(SexCodeType.class));
		assertNotNull("Male code not found", mCode);
		assertEquals("Male code has unexpected ID", TableDataInitializer.CODE_MALE.getId(), mCode.getId());
		assertTrue("Male code is inactive", mCode.isActive());
		
		// test get methods via code type id
		assertNotNull("Sex code type not found", ApplicationCodeUtility.getCodeType(SexCodeType.ID));
		ICode<String> mCode2 = ApplicationCodeUtility.getCode(SexCodeType.ID, TableDataInitializer.CODE_MALE.getId());
		assertNotNull("Male code not found", mCode2);
		assertEquals("Male code has unexpected ID", TableDataInitializer.CODE_MALE.getId(), mCode2.getId());
		assertTrue("Male code is inactive", mCode2.isActive());
	}

	@Test
	public void testStaticEtageCodes() {
		// test exists methods
		assertTrue("Etage code type not found", ApplicationCodeUtility.exists(EtageCodeType.class));
		assertTrue("EG code not found", ApplicationCodeUtility.exists(EtageCodeType.class, EtageCodeType.EG.ID));
		assertTrue("UG sex code not found", ApplicationCodeUtility.exists(EtageCodeType.class, EtageCodeType.UG.ID));

		// test get methods via code type class
		ICode<String> ugCode = ApplicationCodeUtility.getCode(EtageCodeType.class, EtageCodeType.UG.ID);
		assertNotNull("Etage code type not found", ApplicationCodeUtility.getCodeType(EtageCodeType.class));
		assertNotNull("UG code not found", ugCode);
		assertEquals("UG code has unexpected ID", EtageCodeType.UG.ID, ugCode.getId());
		assertTrue("UG code is inactive", ugCode.isActive());
		
		// test get methods via code type id
		assertNotNull("Etage code type not found", ApplicationCodeUtility.getCodeType(EtageCodeType.ID));
		ICode<String> egCode = ApplicationCodeUtility.getCode(EtageCodeType.ID, EtageCodeType.EG.ID);
		assertNotNull("EG code not found", egCode);
		assertEquals("EG code has unexpected ID", EtageCodeType.EG.ID, egCode.getId());
		assertTrue("EG code is inactive", egCode.isActive());
	}

	@Test
	public void testDynamicSexCodes() {
		List<? extends ICode<String>> codes = ApplicationCodeUtility.getCodes(SexCodeType.class);
		assertEquals("Unexpected number of sex codes", 3, codes.size());
		
		ICode<String> uCode = ApplicationCodeUtility.getCode(SexCodeType.class, "U");
		assertNotNull("Undefined sex code not found", uCode);
		assertEquals("Undefined code has unexpected ID", TableDataInitializer.CODE_UNDEFINED.getId(), uCode.getId());
		assertTrue("Undefined code is inactive", uCode.isActive());
	}

	@Test
	public void testDynamicEtageCodes() {
		List<? extends ICode<String>> codes = ApplicationCodeUtility.getCodes(EtageCodeType.class);
		assertEquals("Unexpected number of etage codes", 3, codes.size());
		
		ICode<String> ogCode = ApplicationCodeUtility.getCode(EtageCodeType.class, TableDataInitializer.CODE_OG_2.getId());
		assertNotNull("OG2 code not found", ogCode);
		assertEquals("OG2 code has unexpected ID", TableDataInitializer.CODE_OG_2.getId(), ogCode.getId());
		assertTrue("OG2 code is inactive", ogCode.isActive());
	}

	@Test
	public void testDynamicLocaleCodes() {
		assertTrue("Locale code type not found", ApplicationCodeUtility.exists(LocaleCodeType.class));
		
		List<? extends ICode<String>> codes = ApplicationCodeUtility.getCodes(LocaleCodeType.class);
		assertTrue("Unexpected number of locale codes. Expected 160 or more, found" + codes.size(), codes.size() >= 160);
		assertTrue("Locale code 'de-CH' not found", ApplicationCodeUtility.exists(LocaleCodeType.class, "de-CH"));
	}

	protected DSLContext getContext() {
		try {
			if(connection == null) {
				connection = InitializerApplication.getConnection();
			}
			
			if(!connection.isValid(1)) {
				connection.close();
				connection = InitializerApplication.getConnection();
			}
			
			return InitializerApplication.getContext(connection);
		} 
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

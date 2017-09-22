package com.acme.application.server.document;

import java.math.BigDecimal;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.resource.BinaryResource;
import org.eclipse.scout.rt.platform.util.IOUtility;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.jooq.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.application.database.or.core.tables.Document;
import com.acme.application.database.or.core.tables.records.DocumentRecord;
import com.acme.application.database.table.TableUtility;
import com.acme.application.server.common.AbstractBaseService;
import com.acme.application.shared.code.FileCodeType;
import com.acme.application.shared.common.DateTimeUtility;
import com.acme.application.shared.document.DocumentTablePageData;
import com.acme.application.shared.document.DocumentTablePageData.DocumentTableRowData;
import com.acme.application.shared.document.IDocumentService;

public class DocumentService extends AbstractBaseService<Document, DocumentRecord> implements IDocumentService {

	@Override
	public Document getTable() {
		return Document.DOCUMENT;
	}

	@Override
	public Field<String> getIdColumn() {
		return Document.DOCUMENT.ID;
	}

	@Override
	public Logger getLogger() {
		return LoggerFactory.getLogger(DocumentService.class);
	}

	@Override
	public BinaryResource getResource(String documentId) {
		DocumentRecord document = get(documentId); 
		return new BinaryResource(document.getName(), document.getContent());
	}

	@Override
	public DocumentTablePageData getDocumentTableData(SearchFilter filter) {
		DocumentTablePageData pageData = new DocumentTablePageData();

		getAll()
		.stream()
		.forEach(document -> {
			DocumentTableRowData row = pageData.addRow();
			row.setId(document.getId());
			row.setName(document.getName());
			row.setType(document.getType());
			row.setSize(document.getSize().toBigInteger());
			row.setUser(document.getUserId());
			row.setUploaded(DateTimeUtility.convertToDate(document.getUploaded()));
			row.setActive(document.getActive());
		});
		
		return pageData;
	}

	@Override
	public void store(String name, byte[] content, String userId) {
		String id = TableUtility.createId();
		String type = getDocumentType(name);
		BigDecimal size = BigDecimal.valueOf(content.length);
		String uploaded = DateTimeUtility.nowInUtcAsString();
		DocumentRecord document = new DocumentRecord(id, name, type, size, content, userId, uploaded, true);
		
		store(id, document);
	}
	
	private String getDocumentType(String name) {
        String type = IOUtility.getFileExtension(name);
        return BEANS.get(FileCodeType.class).getCode(type) != null ? type : FileCodeType.UknownCode.ID;
	}
}

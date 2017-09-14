package com.acme.application.server.user;

import java.security.AllPermission;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.util.ObjectUtility;
import org.eclipse.scout.rt.platform.util.StringUtility;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.application.database.or.app.tables.User;
import com.acme.application.database.or.app.tables.UserRole;
import com.acme.application.database.or.app.tables.records.PersonRecord;
import com.acme.application.database.or.app.tables.records.UserRecord;
import com.acme.application.database.or.app.tables.records.UserRoleRecord;
import com.acme.application.database.table.RoleTable;
import com.acme.application.server.common.BaseService;
import com.acme.application.server.person.PersonService;
import com.acme.application.shared.security.PasswordUtility;
import com.acme.application.shared.user.IUserService;
import com.acme.application.shared.user.ProfileFormData;
import com.acme.application.shared.user.UserFormData;
import com.acme.application.shared.user.UserTablePageData;
import com.acme.application.shared.user.ProfileFormData.OptionUserBox;
import com.acme.application.shared.user.UserFormData.UserBox;
import com.acme.application.shared.user.UserFormData.RoleTable.RoleTableRowData;
import com.acme.application.shared.user.UserTablePageData.UserTableRowData;

public class UserService extends BaseService implements IUserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	/**
	 * Returns a list of all usernames.
	 */
	@Override
	public List<String> getUsernames() {
		return getAll()
				.stream()
				.map(user -> { return user.getUsername(); })
				.collect(Collectors.toList());
	}

	/**
	 * Returns true iff a user with the provider username exists.
	 */
	@Override
	public boolean exists(String username) {
		User ut = User.USER;
		DSLContext ctx = getContext();

		return ctx.fetchExists(
				ctx.select()
				.from(ut)
				.where(ut.USERNAME.eq(username))
				);
	}

	/**
	 * Returns all available Users.
	 */
	public List<UserRecord> getAll() {
		return getContext()
				.selectFrom(User.USER)
				.fetchStream()
				.collect(Collectors.toList());
	}

	/**
	 * Gets the user specified by the username.
	 * 
	 * @return the existing user record (or a new empty user record if no existing record can be found)
	 */
	public UserRecord getOrCreate(String username) {
		UserRecord user = get(username);

		if(user != null) {
			return user;
		}

		user = new UserRecord();
		user.setUsername(username);
		user.setActive(true);

		return user;
	}

	/**
	 * Returns the user object for the user specified by the provided user name.
	 *
	 * @return The associated UserRecord or null if no such user exists.
	 */
	public UserRecord get(String username) {
		User user = User.USER;

		return getContext()
				.selectFrom(user)
				.where(user.USERNAME.eq(username))
				.fetchOne();
	}

	/**
	 * Persists the provided user, person data and associated roles. 
	 */
	private void store(UserRecord user, PersonRecord person, List<String> roleIds) {
		BEANS.get(PersonService.class).store(person);
		store(user);
		storeUserRoles(user, roleIds);
	}

	private void store(UserRecord user) {
		LOG.info("persist user {}", user);

		if(exists(user.getUsername())) { getContext().executeUpdate(user); }
		else { getContext().executeInsert(user); }		
	}

	private void storeUserRoles(UserRecord user, List<String> roles) {
		String username = user.getUsername();

		// delete existing user roles
		UserRole urt = UserRole.USER_ROLE;
		getContext()
		.deleteFrom(urt)
		.where(urt.USERNAME.eq(username))
		.execute();

		// add new user roles
		roles.stream().forEach(role -> {
			getContext()
			.executeInsert(new UserRoleRecord(username, role));
		});
	}

	/**
	 * Returns a list of role ids for the user specified by the provided user id.
	 */
	private List<String> getRoles(UserRecord user) {
		if(user == null) {
			return new ArrayList<String>();
		}

		UserRole urt = UserRole.USER_ROLE;
		String username = user.getUsername();
		return getContext()
				.select(urt.ROLE_NAME)
				.from(urt)
				.where(urt.USERNAME.eq(username))
				.fetchStream()
				.map(record -> { 
					return record.getValue(urt.ROLE_NAME); 
				})
				.collect(Collectors.toList());
	}

	@Override
	public List<Permission> getPermissions(String username) {
		List<Permission> permissions = new ArrayList<>();
		List<String> roles = getRoles(get(username));

		// special case: user has root role
		if (roles.contains("root")) {
			permissions.add(new AllPermission());
		}
		// all 'normal' users
		else {
			RoleService roleService = BEANS.get(RoleService.class);

			for (String role : roles) {
				for (Permission permission : roleService.getPermissions(role)) {
					permissions.add(permission);
				}
			}
		}

		return permissions;
	}

	@Override
	public boolean verifyPassword(final String username, final String passwordPlain) {
		UserRecord user = get(username);

		if (user == null) {
			LOG.warn("Provided user is is null");
			return false;
		}

		if (!PasswordUtility.passwordIsValid(passwordPlain, user.getPasswordEncrypted())) {
			LOG.warn("Provided user and password do not match");
			return false;
		}

		LOG.info("Valid password provided for user '{}'", username);
		return true;
	}

	@Override
	public UserFormData load(UserFormData formData) {
		UserRecord user = get(formData.getUserBox().getUserId().getValue());
		addUserData(formData, user);
		addPersonData(formData, user);
		addRoleData(formData, user);

		return formData;
	}

	private UserRecord addUserData(UserFormData formData, UserRecord user) {
		UserBox box = formData.getUserBox();

		if(user != null) {
			box.getLocale().setValue(user.getLocale());
			formData.getPassword().setValue("");
			formData.getAccountLocked().setValue(!user.getActive());
		}
		else {
			formData.getAccountLocked().setValue(false);			
		}

		return user;
	}

	private void addPersonData(UserFormData formData, UserRecord user) {
		UserBox box = formData.getUserBox();

		if(user != null) {
			PersonRecord person = BEANS.get(PersonService.class).get(user.getPersonId());
			box.getFirstName().setValue(person.getFirstName());
			box.getLastName().setValue(person.getLastName());
		}
	}

	private void addRoleData(UserFormData formData, UserRecord user) {
		final List<String> roles = getRoles(user);
		com.acme.application.shared.user.UserFormData.RoleTable rt = formData.getRoleTable();

		BEANS.get(RoleService.class).getAll()
		.stream()
		.forEach(record -> {
			String role = record.getName();
			RoleTableRowData row = rt.addRow();
			row.setId(role);
			row.setRole(TEXTS.getWithFallback(role, role));
			row.setAssigned(roles.contains(role));
		});
	}

	@Override
	public UserFormData store(UserFormData formData) {
		UserRecord user = toUser(formData);
		PersonRecord person = toPerson(formData, user);
		List<String> roleIds = toRoleIds(formData);

		store(user, person, roleIds);

		return formData;
	}

	private List<String> toRoleIds(UserFormData formData) {
		return Arrays.asList(formData.getRoleTable()
				.getRows())
				.stream()
				.filter(row -> row.getAssigned())
				.map(row -> { return row.getId(); })
				.collect(Collectors.toList());
	}

	private UserRecord toUser(UserFormData formData) {
		UserBox box = formData.getUserBox();
		String username = box.getUserId().getValue();
		String password = formData.getPassword().getValue();
		UserRecord user = getOrCreate(username);

		user.setLocale(box.getLocale().getValue());

		// only update password if field contains non-empty value
		if(StringUtility.hasText(password)) {
			user.setPasswordEncrypted(PasswordUtility.calculateEncodedPassword(password));
		}
		user.setActive(!formData.getAccountLocked().getValue());

		return user;
	}

	private PersonRecord toPerson(UserFormData formData, UserRecord user) {
		UserBox box = formData.getUserBox();

		PersonRecord person = BEANS.get(PersonService.class).getOrCreate(user.getPersonId());
		person.setFirstName(box.getFirstName().getValue());
		person.setLastName(box.getLastName().getValue());
		
		// update person id for new users
		if(user.getPersonId() == null) {
			user.setPersonId(person.getId());
		}

		return person;
	}

	@Override
	public UserTablePageData getUserTableData(SearchFilter filter) {
		UserTablePageData pageData = new UserTablePageData();

		getAll()
		.stream()
		.forEach(user -> {
			PersonRecord person = BEANS.get(PersonService.class).get(user.getPersonId());
			boolean isRoot = getRoles(user).contains(RoleTable.ROOT);
			String username = user.getUsername();

			UserTableRowData row = pageData.addRow();
			row.setUserId(username);
			row.setFirstName(person.getFirstName());
			row.setLastName(person.getLastName());
			row.setIsRoot(isRoot);
			row.setIsLocked(!user.getActive());
		});

		return pageData;
	}

	@Override
	public ProfileFormData load(ProfileFormData formData) {
		OptionUserBox box = formData.getOptionUserBox();

		UserRecord user = get(box.getUserId().getValue());
		box.getLocale().setValue(user.getLocale());
		
		PersonRecord person = BEANS.get(PersonService.class).get(user.getPersonId());
		box.getFirstName().setValue(person.getFirstName());
		box.getLastName().setValue(person.getLastName());

		return formData;
	}

	@Override
	public ProfileFormData store(ProfileFormData formData) {
		UserRecord user = updateUser(formData);
		updatePerson(formData, user.getPersonId());

		return formData;
	}

	private UserRecord updateUser(ProfileFormData formData) {
		OptionUserBox box = formData.getOptionUserBox();

		UserRecord user = get(box.getUserId().getValue());
		user.setLocale(box.getLocale().getValue());
		
		String passwordNew = formData.getNewPassword().getValue();
		if(StringUtility.hasText(passwordNew)) {
			String passwordEncoded = PasswordUtility.calculateEncodedPassword(passwordNew);
			user.setPasswordEncrypted(passwordEncoded);
		}
		
		getContext().executeUpdate(user);
		
		return user;
	}

	private void updatePerson(ProfileFormData formData, String personId) {
		OptionUserBox box = formData.getOptionUserBox();
		
		PersonRecord person = BEANS.get(PersonService.class).get(personId);
		person.setFirstName(ObjectUtility.nvl(box.getFirstName().getValue(), ""));
		person.setLastName(ObjectUtility.nvl(box.getLastName().getValue(), ""));
		
		getContext().executeUpdate(person);
	}

	@Override
	public Locale getLocale(String username) {
		if(StringUtility.hasText(username)) {
			return Locale.forLanguageTag(get(username).getLocale());
		}
		
		return Locale.ROOT;
	}
}
/*
 * This file is generated by jOOQ.
*/
package com.acme.application.database.or.app;


import com.acme.application.database.or.app.tables.Code;
import com.acme.application.database.or.app.tables.Person;
import com.acme.application.database.or.app.tables.Role;
import com.acme.application.database.or.app.tables.RolePermission;
import com.acme.application.database.or.app.tables.Text;
import com.acme.application.database.or.app.tables.Type;
import com.acme.application.database.or.app.tables.User;
import com.acme.application.database.or.app.tables.UserRole;
import com.acme.application.database.or.app.tables.records.CodeRecord;
import com.acme.application.database.or.app.tables.records.PersonRecord;
import com.acme.application.database.or.app.tables.records.RolePermissionRecord;
import com.acme.application.database.or.app.tables.records.RoleRecord;
import com.acme.application.database.or.app.tables.records.TextRecord;
import com.acme.application.database.or.app.tables.records.TypeRecord;
import com.acme.application.database.or.app.tables.records.UserRecord;
import com.acme.application.database.or.app.tables.records.UserRoleRecord;

import javax.annotation.Generated;

import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>APP</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CodeRecord> PK_CODE = UniqueKeys0.PK_CODE;
    public static final UniqueKey<PersonRecord> PK_PERSON = UniqueKeys0.PK_PERSON;
    public static final UniqueKey<RoleRecord> PK_ROLE = UniqueKeys0.PK_ROLE;
    public static final UniqueKey<RolePermissionRecord> PK_ROLE_PERMISSION = UniqueKeys0.PK_ROLE_PERMISSION;
    public static final UniqueKey<TextRecord> PK_TEXT = UniqueKeys0.PK_TEXT;
    public static final UniqueKey<TypeRecord> PK_TYPE = UniqueKeys0.PK_TYPE;
    public static final UniqueKey<UserRecord> PK_USER = UniqueKeys0.PK_USER;
    public static final UniqueKey<UserRoleRecord> PK_USER_ROLE = UniqueKeys0.PK_USER_ROLE;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<CodeRecord> PK_CODE = createUniqueKey(Code.CODE, "PK_CODE", Code.CODE.ID, Code.CODE.TYPE_ID);
        public static final UniqueKey<PersonRecord> PK_PERSON = createUniqueKey(Person.PERSON, "PK_PERSON", Person.PERSON.ID);
        public static final UniqueKey<RoleRecord> PK_ROLE = createUniqueKey(Role.ROLE, "PK_ROLE", Role.ROLE.NAME);
        public static final UniqueKey<RolePermissionRecord> PK_ROLE_PERMISSION = createUniqueKey(RolePermission.ROLE_PERMISSION, "PK_ROLE_PERMISSION", RolePermission.ROLE_PERMISSION.ROLE_NAME, RolePermission.ROLE_PERMISSION.PERMISSION);
        public static final UniqueKey<TextRecord> PK_TEXT = createUniqueKey(Text.TEXT, "PK_TEXT", Text.TEXT.KEY, Text.TEXT.LOCALE);
        public static final UniqueKey<TypeRecord> PK_TYPE = createUniqueKey(Type.TYPE, "PK_TYPE", Type.TYPE.ID);
        public static final UniqueKey<UserRecord> PK_USER = createUniqueKey(User.USER, "PK_USER", User.USER.USERNAME);
        public static final UniqueKey<UserRoleRecord> PK_USER_ROLE = createUniqueKey(UserRole.USER_ROLE, "PK_USER_ROLE", UserRole.USER_ROLE.USERNAME, UserRole.USER_ROLE.ROLE_NAME);
    }
}

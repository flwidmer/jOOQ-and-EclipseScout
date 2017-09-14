/*
 * This file is generated by jOOQ.
*/
package com.acme.application.database.or.sys.tables.records;


import com.acme.application.database.or.sys.tables.Sysusers;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysusersRecord extends TableRecordImpl<SysusersRecord> implements Record4<String, String, String, Timestamp> {

    private static final long serialVersionUID = -475020862;

    /**
     * Setter for <code>SYS.SYSUSERS.USERNAME</code>.
     */
    public void setUsername(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>SYS.SYSUSERS.USERNAME</code>.
     */
    public String getUsername() {
        return (String) get(0);
    }

    /**
     * Setter for <code>SYS.SYSUSERS.HASHINGSCHEME</code>.
     */
    public void setHashingscheme(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>SYS.SYSUSERS.HASHINGSCHEME</code>.
     */
    public String getHashingscheme() {
        return (String) get(1);
    }

    /**
     * Setter for <code>SYS.SYSUSERS.PASSWORD</code>.
     */
    public void setPassword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>SYS.SYSUSERS.PASSWORD</code>.
     */
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>SYS.SYSUSERS.LASTMODIFIED</code>.
     */
    public void setLastmodified(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>SYS.SYSUSERS.LASTMODIFIED</code>.
     */
    public Timestamp getLastmodified() {
        return (Timestamp) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, Timestamp> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, Timestamp> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Sysusers.SYSUSERS.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Sysusers.SYSUSERS.HASHINGSCHEME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Sysusers.SYSUSERS.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return Sysusers.SYSUSERS.LASTMODIFIED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getHashingscheme();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getLastmodified();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysusersRecord value1(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysusersRecord value2(String value) {
        setHashingscheme(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysusersRecord value3(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysusersRecord value4(Timestamp value) {
        setLastmodified(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysusersRecord values(String value1, String value2, String value3, Timestamp value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysusersRecord
     */
    public SysusersRecord() {
        super(Sysusers.SYSUSERS);
    }

    /**
     * Create a detached, initialised SysusersRecord
     */
    public SysusersRecord(String username, String hashingscheme, String password, Timestamp lastmodified) {
        super(Sysusers.SYSUSERS);

        set(0, username);
        set(1, hashingscheme);
        set(2, password);
        set(3, lastmodified);
    }
}

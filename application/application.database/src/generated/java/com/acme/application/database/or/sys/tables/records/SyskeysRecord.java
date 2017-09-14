/*
 * This file is generated by jOOQ.
*/
package com.acme.application.database.or.sys.tables.records;


import com.acme.application.database.or.sys.tables.Syskeys;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
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
public class SyskeysRecord extends TableRecordImpl<SyskeysRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 1633593190;

    /**
     * Setter for <code>SYS.SYSKEYS.CONSTRAINTID</code>.
     */
    public void setConstraintid(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>SYS.SYSKEYS.CONSTRAINTID</code>.
     */
    public String getConstraintid() {
        return (String) get(0);
    }

    /**
     * Setter for <code>SYS.SYSKEYS.CONGLOMERATEID</code>.
     */
    public void setConglomerateid(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>SYS.SYSKEYS.CONGLOMERATEID</code>.
     */
    public String getConglomerateid() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Syskeys.SYSKEYS.CONSTRAINTID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Syskeys.SYSKEYS.CONGLOMERATEID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getConstraintid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getConglomerateid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SyskeysRecord value1(String value) {
        setConstraintid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SyskeysRecord value2(String value) {
        setConglomerateid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SyskeysRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SyskeysRecord
     */
    public SyskeysRecord() {
        super(Syskeys.SYSKEYS);
    }

    /**
     * Create a detached, initialised SyskeysRecord
     */
    public SyskeysRecord(String constraintid, String conglomerateid) {
        super(Syskeys.SYSKEYS);

        set(0, constraintid);
        set(1, conglomerateid);
    }
}

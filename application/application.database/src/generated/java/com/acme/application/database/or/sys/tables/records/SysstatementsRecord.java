/*
 * This file is generated by jOOQ.
*/
package com.acme.application.database.or.sys.tables.records;


import com.acme.application.database.or.sys.tables.Sysstatements;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class SysstatementsRecord extends TableRecordImpl<SysstatementsRecord> implements Record9<String, String, String, String, Boolean, String, Timestamp, String, String> {

    private static final long serialVersionUID = 1354833070;

    /**
     * Setter for <code>SYS.SYSSTATEMENTS.STMTID</code>.
     */
    public void setStmtid(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>SYS.SYSSTATEMENTS.STMTID</code>.
     */
    public String getStmtid() {
        return (String) get(0);
    }

    /**
     * Setter for <code>SYS.SYSSTATEMENTS.STMTNAME</code>.
     */
    public void setStmtname(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>SYS.SYSSTATEMENTS.STMTNAME</code>.
     */
    public String getStmtname() {
        return (String) get(1);
    }

    /**
     * Setter for <code>SYS.SYSSTATEMENTS.SCHEMAID</code>.
     */
    public void setSchemaid(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>SYS.SYSSTATEMENTS.SCHEMAID</code>.
     */
    public String getSchemaid() {
        return (String) get(2);
    }

    /**
     * Setter for <code>SYS.SYSSTATEMENTS.TYPE</code>.
     */
    public void setType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>SYS.SYSSTATEMENTS.TYPE</code>.
     */
    public String getType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>SYS.SYSSTATEMENTS.VALID</code>.
     */
    public void setValid(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>SYS.SYSSTATEMENTS.VALID</code>.
     */
    public Boolean getValid() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>SYS.SYSSTATEMENTS.TEXT</code>.
     */
    public void setText(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>SYS.SYSSTATEMENTS.TEXT</code>.
     */
    public String getText() {
        return (String) get(5);
    }

    /**
     * Setter for <code>SYS.SYSSTATEMENTS.LASTCOMPILED</code>.
     */
    public void setLastcompiled(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>SYS.SYSSTATEMENTS.LASTCOMPILED</code>.
     */
    public Timestamp getLastcompiled() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>SYS.SYSSTATEMENTS.COMPILATIONSCHEMAID</code>.
     */
    public void setCompilationschemaid(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>SYS.SYSSTATEMENTS.COMPILATIONSCHEMAID</code>.
     */
    public String getCompilationschemaid() {
        return (String) get(7);
    }

    /**
     * Setter for <code>SYS.SYSSTATEMENTS.USINGTEXT</code>.
     */
    public void setUsingtext(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>SYS.SYSSTATEMENTS.USINGTEXT</code>.
     */
    public String getUsingtext() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<String, String, String, String, Boolean, String, Timestamp, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<String, String, String, String, Boolean, String, Timestamp, String, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Sysstatements.SYSSTATEMENTS.STMTID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Sysstatements.SYSSTATEMENTS.STMTNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Sysstatements.SYSSTATEMENTS.SCHEMAID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Sysstatements.SYSSTATEMENTS.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field5() {
        return Sysstatements.SYSSTATEMENTS.VALID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Sysstatements.SYSSTATEMENTS.TEXT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return Sysstatements.SYSSTATEMENTS.LASTCOMPILED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Sysstatements.SYSSTATEMENTS.COMPILATIONSCHEMAID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Sysstatements.SYSSTATEMENTS.USINGTEXT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getStmtid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getStmtname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSchemaid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value5() {
        return getValid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getLastcompiled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getCompilationschemaid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getUsingtext();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysstatementsRecord value1(String value) {
        setStmtid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysstatementsRecord value2(String value) {
        setStmtname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysstatementsRecord value3(String value) {
        setSchemaid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysstatementsRecord value4(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysstatementsRecord value5(Boolean value) {
        setValid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysstatementsRecord value6(String value) {
        setText(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysstatementsRecord value7(Timestamp value) {
        setLastcompiled(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysstatementsRecord value8(String value) {
        setCompilationschemaid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysstatementsRecord value9(String value) {
        setUsingtext(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysstatementsRecord values(String value1, String value2, String value3, String value4, Boolean value5, String value6, Timestamp value7, String value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysstatementsRecord
     */
    public SysstatementsRecord() {
        super(Sysstatements.SYSSTATEMENTS);
    }

    /**
     * Create a detached, initialised SysstatementsRecord
     */
    public SysstatementsRecord(String stmtid, String stmtname, String schemaid, String type, Boolean valid, String text, Timestamp lastcompiled, String compilationschemaid, String usingtext) {
        super(Sysstatements.SYSSTATEMENTS);

        set(0, stmtid);
        set(1, stmtname);
        set(2, schemaid);
        set(3, type);
        set(4, valid);
        set(5, text);
        set(6, lastcompiled);
        set(7, compilationschemaid);
        set(8, usingtext);
    }
}
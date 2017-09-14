/*
 * This file is generated by jOOQ.
*/
package com.acme.application.database.or.sys.tables.records;


import com.acme.application.database.or.sys.tables.Sysaliases;

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
public class SysaliasesRecord extends TableRecordImpl<SysaliasesRecord> implements Record9<String, String, String, String, String, String, Boolean, Object, String> {

    private static final long serialVersionUID = 1012003562;

    /**
     * Setter for <code>SYS.SYSALIASES.ALIASID</code>.
     */
    public void setAliasid(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>SYS.SYSALIASES.ALIASID</code>.
     */
    public String getAliasid() {
        return (String) get(0);
    }

    /**
     * Setter for <code>SYS.SYSALIASES.ALIAS</code>.
     */
    public void setAlias(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>SYS.SYSALIASES.ALIAS</code>.
     */
    public String getAlias() {
        return (String) get(1);
    }

    /**
     * Setter for <code>SYS.SYSALIASES.SCHEMAID</code>.
     */
    public void setSchemaid(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>SYS.SYSALIASES.SCHEMAID</code>.
     */
    public String getSchemaid() {
        return (String) get(2);
    }

    /**
     * Setter for <code>SYS.SYSALIASES.JAVACLASSNAME</code>.
     */
    public void setJavaclassname(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>SYS.SYSALIASES.JAVACLASSNAME</code>.
     */
    public String getJavaclassname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>SYS.SYSALIASES.ALIASTYPE</code>.
     */
    public void setAliastype(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>SYS.SYSALIASES.ALIASTYPE</code>.
     */
    public String getAliastype() {
        return (String) get(4);
    }

    /**
     * Setter for <code>SYS.SYSALIASES.NAMESPACE</code>.
     */
    public void setNamespace(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>SYS.SYSALIASES.NAMESPACE</code>.
     */
    public String getNamespace() {
        return (String) get(5);
    }

    /**
     * Setter for <code>SYS.SYSALIASES.SYSTEMALIAS</code>.
     */
    public void setSystemalias(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>SYS.SYSALIASES.SYSTEMALIAS</code>.
     */
    public Boolean getSystemalias() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>SYS.SYSALIASES.ALIASINFO</code>.
     */
    public void setAliasinfo(Object value) {
        set(7, value);
    }

    /**
     * Getter for <code>SYS.SYSALIASES.ALIASINFO</code>.
     */
    public Object getAliasinfo() {
        return (Object) get(7);
    }

    /**
     * Setter for <code>SYS.SYSALIASES.SPECIFICNAME</code>.
     */
    public void setSpecificname(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>SYS.SYSALIASES.SPECIFICNAME</code>.
     */
    public String getSpecificname() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<String, String, String, String, String, String, Boolean, Object, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<String, String, String, String, String, String, Boolean, Object, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Sysaliases.SYSALIASES.ALIASID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Sysaliases.SYSALIASES.ALIAS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Sysaliases.SYSALIASES.SCHEMAID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Sysaliases.SYSALIASES.JAVACLASSNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Sysaliases.SYSALIASES.ALIASTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Sysaliases.SYSALIASES.NAMESPACE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field7() {
        return Sysaliases.SYSALIASES.SYSTEMALIAS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Object> field8() {
        return Sysaliases.SYSALIASES.ALIASINFO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Sysaliases.SYSALIASES.SPECIFICNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getAliasid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getAlias();
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
        return getJavaclassname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getAliastype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getNamespace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value7() {
        return getSystemalias();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object value8() {
        return getAliasinfo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getSpecificname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysaliasesRecord value1(String value) {
        setAliasid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysaliasesRecord value2(String value) {
        setAlias(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysaliasesRecord value3(String value) {
        setSchemaid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysaliasesRecord value4(String value) {
        setJavaclassname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysaliasesRecord value5(String value) {
        setAliastype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysaliasesRecord value6(String value) {
        setNamespace(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysaliasesRecord value7(Boolean value) {
        setSystemalias(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysaliasesRecord value8(Object value) {
        setAliasinfo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysaliasesRecord value9(String value) {
        setSpecificname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysaliasesRecord values(String value1, String value2, String value3, String value4, String value5, String value6, Boolean value7, Object value8, String value9) {
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
     * Create a detached SysaliasesRecord
     */
    public SysaliasesRecord() {
        super(Sysaliases.SYSALIASES);
    }

    /**
     * Create a detached, initialised SysaliasesRecord
     */
    public SysaliasesRecord(String aliasid, String alias, String schemaid, String javaclassname, String aliastype, String namespace, Boolean systemalias, Object aliasinfo, String specificname) {
        super(Sysaliases.SYSALIASES);

        set(0, aliasid);
        set(1, alias);
        set(2, schemaid);
        set(3, javaclassname);
        set(4, aliastype);
        set(5, namespace);
        set(6, systemalias);
        set(7, aliasinfo);
        set(8, specificname);
    }
}

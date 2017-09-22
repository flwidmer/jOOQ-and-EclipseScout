/*
 * This file is generated by jOOQ.
*/
package com.acme.application.database.or.core.tables;


import com.acme.application.database.or.core.Core;
import com.acme.application.database.or.core.Keys;
import com.acme.application.database.or.core.tables.records.TypeRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Type extends TableImpl<TypeRecord> {

    private static final long serialVersionUID = -298318690;

    /**
     * The reference instance of <code>core.TYPE</code>
     */
    public static final Type TYPE = new Type();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TypeRecord> getRecordType() {
        return TypeRecord.class;
    }

    /**
     * The column <code>core.TYPE.ID</code>.
     */
    public final TableField<TypeRecord, String> ID = createField("ID", org.jooq.impl.SQLDataType.VARCHAR.length(36).nullable(false), this, "");

    /**
     * The column <code>core.TYPE.CODE_TYPE</code>.
     */
    public final TableField<TypeRecord, String> CODE_TYPE = createField("CODE_TYPE", org.jooq.impl.SQLDataType.VARCHAR.length(36), this, "");

    /**
     * Create a <code>core.TYPE</code> table reference
     */
    public Type() {
        this("TYPE", null);
    }

    /**
     * Create an aliased <code>core.TYPE</code> table reference
     */
    public Type(String alias) {
        this(alias, TYPE);
    }

    private Type(String alias, Table<TypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Type(String alias, Table<TypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Core.CORE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TypeRecord> getPrimaryKey() {
        return Keys.PK_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TypeRecord>> getKeys() {
        return Arrays.<UniqueKey<TypeRecord>>asList(Keys.PK_TYPE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type as(String alias) {
        return new Type(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Type rename(String name) {
        return new Type(name, null);
    }
}
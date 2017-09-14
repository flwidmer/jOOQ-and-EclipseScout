/*
 * This file is generated by jOOQ.
*/
package com.acme.application.database.or.sys.tables;


import com.acme.application.database.generator.converter.LongConverter;
import com.acme.application.database.or.sys.Sys;
import com.acme.application.database.or.sys.tables.records.SyssequencesRecord;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


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
public class Syssequences extends TableImpl<SyssequencesRecord> {

    private static final long serialVersionUID = -609407752;

    /**
     * The reference instance of <code>SYS.SYSSEQUENCES</code>
     */
    public static final Syssequences SYSSEQUENCES = new Syssequences();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SyssequencesRecord> getRecordType() {
        return SyssequencesRecord.class;
    }

    /**
     * The column <code>SYS.SYSSEQUENCES.SEQUENCEID</code>.
     */
    public final TableField<SyssequencesRecord, String> SEQUENCEID = createField("SEQUENCEID", org.jooq.impl.SQLDataType.CHAR.length(36).nullable(false), this, "");

    /**
     * The column <code>SYS.SYSSEQUENCES.SEQUENCENAME</code>.
     */
    public final TableField<SyssequencesRecord, String> SEQUENCENAME = createField("SEQUENCENAME", org.jooq.impl.SQLDataType.VARCHAR.length(128).nullable(false), this, "");

    /**
     * The column <code>SYS.SYSSEQUENCES.SCHEMAID</code>.
     */
    public final TableField<SyssequencesRecord, String> SCHEMAID = createField("SCHEMAID", org.jooq.impl.SQLDataType.CHAR.length(36).nullable(false), this, "");

    /**
     * The column <code>SYS.SYSSEQUENCES.SEQUENCEDATATYPE</code>.
     */
    public final TableField<SyssequencesRecord, String> SEQUENCEDATATYPE = createField("SEQUENCEDATATYPE", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>SYS.SYSSEQUENCES.CURRENTVALUE</code>.
     */
    public final TableField<SyssequencesRecord, BigDecimal> CURRENTVALUE = createField("CURRENTVALUE", org.jooq.impl.SQLDataType.BIGINT, this, "", new LongConverter());

    /**
     * The column <code>SYS.SYSSEQUENCES.STARTVALUE</code>.
     */
    public final TableField<SyssequencesRecord, BigDecimal> STARTVALUE = createField("STARTVALUE", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "", new LongConverter());

    /**
     * The column <code>SYS.SYSSEQUENCES.MINIMUMVALUE</code>.
     */
    public final TableField<SyssequencesRecord, BigDecimal> MINIMUMVALUE = createField("MINIMUMVALUE", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "", new LongConverter());

    /**
     * The column <code>SYS.SYSSEQUENCES.MAXIMUMVALUE</code>.
     */
    public final TableField<SyssequencesRecord, BigDecimal> MAXIMUMVALUE = createField("MAXIMUMVALUE", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "", new LongConverter());

    /**
     * The column <code>SYS.SYSSEQUENCES.INCREMENT</code>.
     */
    public final TableField<SyssequencesRecord, BigDecimal> INCREMENT = createField("INCREMENT", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "", new LongConverter());

    /**
     * The column <code>SYS.SYSSEQUENCES.CYCLEOPTION</code>.
     */
    public final TableField<SyssequencesRecord, String> CYCLEOPTION = createField("CYCLEOPTION", org.jooq.impl.SQLDataType.CHAR.length(1).nullable(false), this, "");

    /**
     * Create a <code>SYS.SYSSEQUENCES</code> table reference
     */
    public Syssequences() {
        this("SYSSEQUENCES", null);
    }

    /**
     * Create an aliased <code>SYS.SYSSEQUENCES</code> table reference
     */
    public Syssequences(String alias) {
        this(alias, SYSSEQUENCES);
    }

    private Syssequences(String alias, Table<SyssequencesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Syssequences(String alias, Table<SyssequencesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Sys.SYS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Syssequences as(String alias) {
        return new Syssequences(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Syssequences rename(String name) {
        return new Syssequences(name, null);
    }
}

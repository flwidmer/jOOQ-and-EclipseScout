package com.acme.application.server.sql;

import javax.security.auth.Subject;

import org.eclipse.scout.rt.platform.config.AbstractBooleanConfigProperty;
import org.eclipse.scout.rt.platform.config.AbstractStringConfigProperty;
import org.eclipse.scout.rt.platform.config.AbstractSubjectConfigProperty;

// tag::structure[]
public class DatabaseProperties {

  public static class DatabaseAutoCreateProperty extends AbstractBooleanConfigProperty {
    // defines default value and key

    @Override
    protected Boolean getDefaultValue() {
      return Boolean.TRUE; // <1>
    }

    @Override
    public String getKey() {
      return "contacts.database.autocreate"; // <2>
    }
  }

  public static class DatabaseAutoPopulateProperty extends AbstractBooleanConfigProperty {
    // defines default value and key
    // end::structure[]

    @Override
    protected Boolean getDefaultValue() {
      return Boolean.TRUE;
    }

    @Override
    public String getKey() {
      return "contacts.database.autopopulate";
    }
    // tag::structure[]
  }

  public static class JdbcMappingNameProperty extends AbstractStringConfigProperty {
    // defines default value and key
    // end::structure[]

    @Override
    protected String getDefaultValue() {
      return "jdbc:derby:memory:contacts-database";
    }

    @Override
    public String getKey() {
      return "contacts.database.jdbc.mapping.name";
    }
    // tag::structure[]
  }

  public static class SuperUserSubjectProperty extends AbstractSubjectConfigProperty {
    // defines default value and key
    // end::structure[]

    @Override
    protected Subject getDefaultValue() {
      return convertToSubject("system");
    }

    @Override
    public String getKey() {
      return "contacts.superuser";
    }
    // tag::structure[]
  }
}
// end::structure[]

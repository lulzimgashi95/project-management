package sql;

/**
 * Created by LulzimG on 24/12/16.
 */
public class DDL {
    public static final String CREATE_PROJECT = "CREATE TABLE projects( id VARCHAR(36) PRIMARY KEY NOT NULL, name TEXT, description TEXT, startDate DATETIME, deadLine DATETIME, active TINYINT(4) DEFAULT '1');";
    public static final String CREATE_MEMBER = "CREATE TABLE members( id VARCHAR(36) PRIMARY KEY NOT NULL, firstName TEXT, lastName TEXT, startDate DATETIME, position TEXT, project_id VARCHAR(36), active TINYINT(4) DEFAULT '1', image LONGBLOB);";
    public static final String CREATE_SPONSOR = "CREATE TABLE sponsors( id VARCHAR(36) PRIMARY KEY NOT NULL, name TEXT, amount DOUBLE, project_id VARCHAR(36), active TINYINT(4) DEFAULT '1');";
    public static final String CREATE_NOTE = "CREATE TABLE notes( id VARCHAR(36) PRIMARY KEY NOT NULL, note TEXT, project_id VARCHAR(36), date DATETIME DEFAULT NOW(), active TINYINT(4) DEFAULT '1', image LONGBLOB);";
    public static final String CREATE_TRIGGER = "create trigger remove_childs after update ON projects for each row begin if NEW.active = 0 then update sponsors set active=new.active where project_id=new.id; update members set active=new.active where project_id=new.id; end if; end$$";

}


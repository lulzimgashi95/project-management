CREATE TABLE projects (
  id          VARCHAR(36) PRIMARY KEY NOT NULL,
  name        TEXT,
  description TEXT,
  startDate   DATETIME,
  deadLine    DATETIME,
  active      TINYINT(4) DEFAULT '1'
);

CREATE TABLE members (
  id         VARCHAR(36) PRIMARY KEY NOT NULL,
  firstName  TEXT,
  lastName   TEXT,
  startDate  DATETIME,
  position   TEXT,
  project_id VARCHAR(36),
  active     TINYINT(4) DEFAULT '1',
  image      LONGBLOB
);

CREATE TABLE sponsors (
  id         VARCHAR(36) PRIMARY KEY NOT NULL,
  name       TEXT,
  amount     DOUBLE,
  project_id VARCHAR(36),
  active     TINYINT(4) DEFAULT '1'
);

CREATE TABLE notes (
  id         VARCHAR(36) PRIMARY KEY NOT NULL,
  note       TEXT,
  project_id VARCHAR(36),
  date       DATETIME   DEFAULT NOW(),
  active     TINYINT(4) DEFAULT '1',
  image      LONGBLOB
);

CREATE TRIGGER remove_childs
AFTER UPDATE ON projects
FOR EACH ROW
  BEGIN IF NEW.active = 0
  THEN UPDATE sponsors
  SET active = new.active
  WHERE project_id = new.id;
    UPDATE members
    SET active = new.active
    WHERE project_id = new.id; END IF;
    end$$
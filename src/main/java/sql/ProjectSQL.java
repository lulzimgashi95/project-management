package sql;

/**
 * Created by LulzimG on 23/12/16.
 */
public class ProjectSQL {
    public static final String GET_ALL_PROJECTS = "SELECT * FROM projects WHERE active=1";
    public static final String GET_PROJECT = "SELECT * FROM projects WHERE id = ? AND active=1";
    public static final String INSERT_PROJECT = "INSERT INTO projects(id,name,description,startDate,deadLine) VALUES (:id,:name,:description,:startDate,:deadLine)" +
            " ON DUPLICATE KEY UPDATE name=:name,description=:description,startDate=:startDate,deadLine=:deadLine";
    public static final String REMOVE_PROJECT = "UPDATE projects SET active = 0 WHERE id=?";

}

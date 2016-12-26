package sql;

/**
 * Created by LulzimG on 23/12/16.
 */
public class MemberSQL {
    public static final String GET_PROJECT_MEMBERS = "SELECT * FROM members WHERE project_id=? AND active=1";
    public static final String GET_ALL_MEMBERS = "SELECT m.id,m.firstName,m.lastName,m.startDate,m.position,m.project_id,m.image,p.name as project_name FROM members m INNER JOIN projects p ON m.project_id=p.id WHERE m.active=1";
    public static final String GET_MEMBER = "SELECT m.id,m.firstName,m.lastName,m.startDate,m.position,m.project_id,p.name as project_name,m.image  FROM members m INNER JOIN projects p ON m.project_id=p.id WHERE m.id=?";
    public static final String INSERT_MEMBER = "INSERT INTO members(id,firstName,lastName,startDate,position,project_id,image) VALUES(:id,:firstName,:lastName,:startDate,:position,:project_id,:image)" +
            "ON DUPLICATE KEY UPDATE firstName=:firstName,lastName=:lastName,startDate=:startDate,position=:position,project_id=:project_id,image=:image";
    public static final String REMOVE_MEMBER = "UPDATE members SET active = 0 WHERE id=?";

}

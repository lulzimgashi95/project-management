package sql;

/**
 * Created by LulzimG on 23/12/16.
 */
public class SponsorSQL {
    public static final String GET_PROJECT_SPONSORS = "SELECT * FROM sponsors WHERE project_id=? AND active=1";
    public static final String INSERT_SPONSOR = "INSERT INTO sponsors(id,name,amount,project_id) VALUES(:id,:name,:amount,:project_id)" +
            "ON DUPLICATE KEY UPDATE name=:name,amount=:amount,project_id=:project_id";
    public static final String REMOVE_SPONSOR = "UPDATE sponsors SET active = 0 WHERE id=?";

}

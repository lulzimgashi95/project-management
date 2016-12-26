package sql;

/**
 * Created by LulzimG on 23/12/16.
 */
public class NoteSQL {
    public static final String GET_PROJECT_NOTES = "SELECT * FROM notes WHERE project_id = ? AND active=1";
    public static final String INSERT_NOTE = "INSERT INTO notes(id,note,image,project_id) VALUES (:id,:note,:image,:project_id)" +
            "ON DUPLICATE KEY UPDATE note=:note,image=:image";
    public static final String REMOVE_NOTE = "UPDATE notes SET active = 0 WHERE id = ? ";

}

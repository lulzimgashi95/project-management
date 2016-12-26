package rowMappers;

import models.Note;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LulzimG on 22/12/16.
 */
public class NoteRowMapper implements RowMapper<Note> {
    public Note mapRow(ResultSet resultSet, int i) throws SQLException {
        Note note = new Note();
        note.setId(resultSet.getString("id"));
        note.setNote(resultSet.getString("note"));
        note.setImage(resultSet.getString("image"));
        note.setDate(resultSet.getDate("date"));
        note.setProjectId(resultSet.getString("project_id"));

        return note;
    }
}

package services;

import models.Note;
import rowMappers.NoteRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import sql.NoteSQL;

import java.util.List;
import java.util.UUID;

/**
 * Created by LulzimG on 22/12/16.
 */
@Service("noteService")
public class NoteServiceImp implements NoteService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Note> getNotesForProject(String projectId) {
        List<Note> notes;
        try {
            notes = this.jdbcTemplate.query(NoteSQL.GET_PROJECT_NOTES,
                    new Object[]{projectId}, new NoteRowMapper());
        } catch (Exception e) {
            return null;
        }
        return notes;
    }

    public String insertNote(Note note, String projectId) {

        UUID id = UUID.randomUUID();
        note.setId(id.toString());

        SqlParameterSource parameters = new MapSqlParameterSource().addValue("id", note.getId())
                .addValue("note", note.getNote())
                .addValue("image", note.getImage())
                .addValue("project_id", projectId);

        try {
            this.namedParameterJdbcTemplate.update(NoteSQL.INSERT_NOTE, parameters);
        } catch (Exception e) {
            return "Failed";
        }
        return "Succeed";
    }

    public String removeNote(String id) {
        try {
            this.jdbcTemplate.update(NoteSQL.REMOVE_NOTE, new Object[]{id});
        } catch (Exception e) {
            return "Failed";
        }
        return "Succeed";
    }
}

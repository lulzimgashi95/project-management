package rowMappers;

import models.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LulzimG on 17/12/16.
 */
public class ProjectRowMapper implements RowMapper<Project> {
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {

        Project project = new Project();
        project.setId(resultSet.getObject("id").toString());
        project.setName(resultSet.getString("name"));
        project.setDescription(resultSet.getString("description"));
        project.setStartDate(resultSet.getDate("startDate"));
        project.setDeadLine(resultSet.getDate("deadLine"));

        return project;
    }
}

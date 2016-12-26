package rowMappers;

import models.Statistic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LulzimG on 24/12/16.
 */
public class StatisticRowMapper implements RowMapper<Statistic> {
    public Statistic mapRow(ResultSet resultSet, int i) throws SQLException {
        Statistic statistic = new Statistic();
        statistic.setProjects(resultSet.getString("projects"));
        statistic.setMembers(resultSet.getString("members"));
        statistic.setSponsors(resultSet.getString("sponsors"));
        statistic.setNotes(resultSet.getString("notes"));

        return statistic;
    }
}

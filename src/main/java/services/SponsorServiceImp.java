package services;

import models.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import rowMappers.SponsorRowMapper;
import sql.SponsorSQL;

import java.util.List;
import java.util.UUID;

/**
 * Created by LulzimG on 17/12/16.
 */
@Service("sponsorService")
public class SponsorServiceImp implements SponsorService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Sponsor> getSponsorsForProject(String projectId) {
        List<Sponsor> sponsors;
        try {
            sponsors = jdbcTemplate.query(SponsorSQL.GET_PROJECT_SPONSORS,
                    new Object[]{projectId}, new SponsorRowMapper());
        } catch (Exception e) {
            return null;
        }

        return sponsors;
    }

    public String insertSponsor(Sponsor sponsor) {
        if (sponsor.getId() == null) {
            UUID id = UUID.randomUUID();
            sponsor.setId(id.toString());
        }

        SqlParameterSource parameters = new MapSqlParameterSource().addValue("id", sponsor.getId())
                .addValue("name", sponsor.getName())
                .addValue("amount", sponsor.getAmount())
                .addValue("project_id", sponsor.getProjectId());

        try {
            this.namedParameterJdbcTemplate.update(SponsorSQL.INSERT_SPONSOR, parameters);
        } catch (Exception e) {
            return "Failed";
        }
        return "Succeed";
    }

    public String removeSponsor(String id) {
        try {
            this.jdbcTemplate.update(SponsorSQL.REMOVE_SPONSOR, new Object[]{id});
        } catch (Exception e) {
            return "Failed";
        }
        return "Succeed";
    }
}

package services;

import models.Member;
import models.Project;
import models.Sponsor;
import rowMappers.ProjectRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import sql.ProjectSQL;

import java.util.List;
import java.util.UUID;

/**
 * Created by LulzimG on 17/12/16.
 */
@Service("projectService")
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MemberService memberServiceImp;

    @Autowired
    private SponsorServiceImp sponsorServiceImp;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Project> getAllProject() {
        List<Project> projects;
        try {
            projects = jdbcTemplate.query(ProjectSQL.GET_ALL_PROJECTS, new ProjectRowMapper());
        } catch (Exception e) {
            return null;
        }

        return projects;
    }

    public Project getProject(String id) {
        Project project;
        try {
            project = jdbcTemplate.queryForObject(ProjectSQL.GET_PROJECT,
                    new Object[]{id}, new ProjectRowMapper());
        } catch (Exception e) {
            return null;
        }

        List<Member> members = memberServiceImp.getProjectMembers(id);
        List<Sponsor> sponsors = sponsorServiceImp.getSponsorsForProject(id);

        Double budget = 0.0;
        if (sponsors != null) {
            for (Sponsor sponsor : sponsors) {
                budget = budget + sponsor.getAmount();
            }
        }
        project.setBudget(budget);

        project.setMembers(members);
        project.setSponsors(sponsors);
        return project;
    }

    public String insertProject(Project project) {
        if (project.getId() == null) {
            UUID id = UUID.randomUUID();
            project.setId(id.toString());
        }

        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", project.getId())
                .addValue("name", project.getName())
                .addValue("description", project.getDescription())
                .addValue("startDate", project.getStartDate())
                .addValue("deadLine", project.getDeadLine())
                .addValue("budget", project.getBudget());

        try {
            this.namedParameterJdbcTemplate.update(ProjectSQL.INSERT_PROJECT,
                    parameters);
        } catch (Exception e) {
            return "Failed";
        }
        return "Succeed";
    }

    public String deleteProject(String id) {
        try {
            this.jdbcTemplate.update(ProjectSQL.REMOVE_PROJECT, new Object[]{id});
        } catch (Exception e) {
            return "Failed";
        }

        return "Succeed";
    }

}

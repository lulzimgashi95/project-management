package services;

import models.Member;
import rowMappers.MemberRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import sql.MemberSQL;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/**
 * Created by LulzimG on 17/12/16.
 */
@Service("memberService")
public class MemberServiceImp implements MemberService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Member> getProjectMembers(String project_id) {
        List<Member> members;
        try {
            members = this.jdbcTemplate.query(MemberSQL.GET_PROJECT_MEMBERS,
                    new Object[]{project_id}, new MemberRowMapper());
        } catch (Exception e) {
            return null;
        }
        return members;
    }

    public List<Member> getAllMembers() {
        List<Member> members;
        try {
            members = this.jdbcTemplate.query(MemberSQL.GET_ALL_MEMBERS, new Object[]{}, new MemberRowMapper());
        } catch (Exception e) {
            return null;
        }

        Collections.sort(members, new Comparator<Member>() {
            public int compare(Member o1, Member o2) {
                return o1.getProjectName().compareTo(o2.getProjectName());
            }
        });

        return members;
    }

    public Member getMember(String id) {
        Member member;
        try {
            member = this.jdbcTemplate.queryForObject(MemberSQL.GET_MEMBER, new Object[]{id}, new MemberRowMapper());
        } catch (Exception e) {
            return null;
        }
        return member;
    }

    public String insertMember(Member member) {
        if (member.getId() == null) {
            UUID id = UUID.randomUUID();
            member.setId(id.toString());
        }

        SqlParameterSource parameters;
        parameters = new MapSqlParameterSource()
                .addValue("id", member.getId())
                .addValue("firstName", member.getFirstName())
                .addValue("lastName", member.getLastName())
                .addValue("startDate", member.getStartDate())
                .addValue("position", member.getPosition())
                .addValue("project_id", member.getProjectId())
                .addValue("image", member.getImage());

        try {
            this.namedParameterJdbcTemplate.update(MemberSQL.INSERT_MEMBER, parameters);
        } catch (Exception e) {
            return "Failed";
        }
        return "Succeed";
    }

    public String removeMember(String id) {
        try {
            this.jdbcTemplate.update(MemberSQL.REMOVE_MEMBER, new Object[]{id});
        } catch (Exception e) {
            return "Failed";
        }
        return "Succeed";
    }
}

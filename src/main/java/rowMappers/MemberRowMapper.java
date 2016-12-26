package rowMappers;

import models.Member;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LulzimG on 17/12/16.
 */
public class MemberRowMapper implements RowMapper<Member> {
    public Member mapRow(ResultSet resultSet, int i) throws SQLException {
        Member member = new Member();
        member.setId(resultSet.getString("id"));
        member.setFirstName(resultSet.getString("firstName"));
        member.setLastName(resultSet.getString("lastName"));
        member.setStartDate(resultSet.getDate("startDate"));
        member.setPosition(resultSet.getString("position"));
        member.setProjectId(resultSet.getString("project_id"));
        try {
            member.setProjectName(resultSet.getString("project_name"));
        } catch (Exception e) {

        }
        member.setImage(resultSet.getString("image"));
        return member;
    }
}

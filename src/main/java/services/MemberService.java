package services;

import models.Member;

import java.util.List;

/**
 * Created by LulzimG on 19/12/16.
 */
public interface MemberService {
    List<Member> getProjectMembers(String project_id);

    List<Member> getAllMembers();

    Member getMember(String id);

    String insertMember(Member member);

    String removeMember(String id);
}

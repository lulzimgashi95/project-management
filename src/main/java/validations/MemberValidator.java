package validations;

import models.Member;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by LulzimG on 20/12/16.
 */
public class MemberValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return Member.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        Member member = (Member) o;
        if (member.getFirstName().length() < 3) {
            errors.rejectValue("firstName", "firstName", "FirstName must contains more than 3 characters");
        }
        if (member.getLastName().length() < 3) {
            errors.rejectValue("lastName", "lastName", "LastName must contains more than 3 characters");
        }
        if (member.getPosition().length() == 0) {
            errors.rejectValue("position", "position", "Position must be not null");
        }
        if (member.getProjectId() == null) {
            errors.rejectValue("projectId", "projectId", "Please create a project first");
        }
    }
}

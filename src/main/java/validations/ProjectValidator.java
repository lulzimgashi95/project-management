package validations;

import models.Project;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by LulzimG on 20/12/16.
 */
public class ProjectValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        boolean equals = Project.class.equals(aClass);
        return equals;
    }

    public void validate(Object o, Errors errors) {
        Project project = (Project) o;
        if (project.getName().length() < 3) {
            errors.rejectValue("name", "name", "Name should contains more than 3 characters");
        }
        if (project.getDescription().length() < 10) {
            errors.rejectValue("description", "description", "Description should contains more than 10 characters");
        }

    }
}

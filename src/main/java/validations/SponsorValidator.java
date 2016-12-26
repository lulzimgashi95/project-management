package validations;

import models.Sponsor;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by LulzimG on 20/12/16.
 */
public class SponsorValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return Sponsor.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        Sponsor sponsor = (Sponsor) o;

        if (sponsor.getName().length() < 3) {
            errors.rejectValue("name", "name", "Sponsor name must contains more than 3 characters");
        }
        if (sponsor.getAmount() <= 0.0) {
            errors.rejectValue("amount", "amount", "Amount should me greater 0");
        }
    }
}

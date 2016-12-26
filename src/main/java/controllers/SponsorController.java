package controllers;

import models.Sponsor;
import services.SponsorService;
import validations.SponsorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;


/**
 * Created by LulzimG on 17/12/16.
 */
@Controller
@RequestMapping("/sponsor")
@SessionAttributes("sponsor")
public class SponsorController {

    @Autowired
    private SponsorService sponsorService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addSponsorGet(Model model, @ModelAttribute Sponsor sponsor) {
        return "add_sponsor";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addSponsorPOST(@Valid @ModelAttribute Sponsor sponsor, Errors errors, SessionStatus status) {

        if (errors.hasErrors()) {
            return "add_sponsor";
        }

        String result = sponsorService.insertSponsor(sponsor);
        if (result.equals("Failed")) {
            return "add_sponsor";
        } else {
            status.setComplete();
            return "redirect:/project/" + sponsor.getProjectId();
        }
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeSponsor(@ModelAttribute Sponsor sponsor) {
        sponsorService.removeSponsor(sponsor.getId());
        return "redirect:/project/" + sponsor.getProjectId();
    }

    @ModelAttribute("sponsor")
    public Sponsor getProject() {
        return new Sponsor();
    }

   /* @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.addValidators(new SponsorValidator());
    }*/
}

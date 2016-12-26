package controllers;

import models.Member;
import models.Project;
import services.MemberService;
import services.ProjectService;
import validations.MemberValidator;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LulzimG on 18/12/16.
 */
@Controller
@RequestMapping("/member")
@SessionAttributes("member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping("")
    public String getAllMembers(Model model, SessionStatus status) {
        model.addAttribute("members", memberService.getAllMembers());

        status.setComplete();
        return "members";
    }

    @RequestMapping("/{id}")
    public String getMember(Model model, @PathVariable String id) {
        Member member = memberService.getMember(id);
        Member memberModel = new Member();
        BeanUtils.copyProperties(member, memberModel);


        model.addAttribute("member", memberModel);
        return "member";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addMemberGet(Model model, @ModelAttribute Member member, @RequestHeader(value = "referer", required = false) String referer) {

        model.addAttribute("projects", projectService.getAllProject());
        if (referer != null) {
            if (referer.contains("/project/")) {
                model.addAttribute("member", new Member());
                Project project = projectService.getProject(member.getProjectId());
                List<Project> projects = new ArrayList<Project>();
                projects.add(project);
                model.addAttribute("projects", projects);
            }
        }
        return "add_member";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addMemberPost(Model model, MultipartFile file, @Valid @ModelAttribute Member member, Errors errors,SessionStatus status) {
        if (errors.hasErrors()) {
            model.addAttribute("projects", projectService.getAllProject());
            return "add_member";
        }

        String encoded = "";
        try {
            encoded = Base64.encode(file.getBytes());
        } catch (Exception e) {

        }

        if (encoded.length() > 0) {
            member.setImage(encoded);
        }

        String result = memberService.insertMember(member);
        if (result.equals("Failed")) {
            return "add_member";
        }

        status.setComplete();
        return "redirect:/member/" + member.getId();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeMember(@ModelAttribute Member member, @RequestHeader("referer") String referer) {
        memberService.removeMember(member.getId());

        if (referer.contains("/project/")) {
            return "redirect:/project/" + member.getProjectId();
        } else {
            return "redirect:/member";
        }
    }

    @ModelAttribute("member")
    public Member getMember() {
        return new Member();
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.addValidators(new MemberValidator());
    }
}

package controllers;

import models.Project;
import services.ProjectService;
import validations.ProjectValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


/**
 * Created by LulzimG on 17/12/16.
 */
@Controller
@RequestMapping("/project")
@SessionAttributes("project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping("")
    public String getAllProjects(Model model, SessionStatus sessionStatus) {
        model.addAttribute("projects", projectService.getAllProject());

        sessionStatus.setComplete();
        return "projects";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getProject(Model model, @PathVariable String id) {
        Project project = projectService.getProject(id);
        Project projectModel = new Project();
        BeanUtils.copyProperties(project, projectModel);

        model.addAttribute("project", projectModel);
        return "project";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProjectGet() {
        return "add_project";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProjectPost(@Valid @ModelAttribute Project project, Errors errors, SessionStatus sessionStatus) {

        if (errors.hasErrors()) {
            return "add_project";
        }
        String result = projectService.insertProject(project);
        if (result.equals("Failed")) {
            return "add_project";
        } else {
            sessionStatus.setComplete();
            return "redirect:/project/" + project.getId();
        }
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeProject(@ModelAttribute Project project) {
        String result = projectService.deleteProject(project.getId());

        return "redirect:/project";
    }

    @ModelAttribute("project")
    public Project getProject() {
        return new Project();
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProjectValidator());
    }
}

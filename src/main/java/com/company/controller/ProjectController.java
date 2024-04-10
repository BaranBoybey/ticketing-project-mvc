package com.company.controller;

import com.company.dto.ProjectDTO;
import com.company.enums.Status;
import com.company.service.ProjectService;
import com.company.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final UserService userService;
    private final ProjectService projectService;

    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String projectCreate(Model model) {
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("managerList", userService.findManagers());
        model.addAttribute("projectList", projectService.findAll());
        return "/project/create";
    }

    @PostMapping("/create")
    public String saveProject(@ModelAttribute("project") ProjectDTO projectDTO) {

        projectService.save(projectDTO);
        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteButton(Model model, @PathVariable("projectCode") String projectCode) {
        projectService.deleteById(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectCode}")
    public String completeButton(@PathVariable("projectCode") String projectCode) {
        projectService.projectComplete(projectService.findById(projectCode));
        return "project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String updateButton(Model model, @PathVariable("projectCode") String projectCode) {
        model.addAttribute("project", projectService.findById(projectCode));
        model.addAttribute("managerList", userService.findManagers());
        model.addAttribute("projectList", projectService.findAll());
        return "/project/update";
    }

    @PostMapping("/update")
    public String updateProject(@ModelAttribute("project") ProjectDTO projectDTO) {
        projectService.update(projectDTO);
        return "redirect:/user/create";
    }
}

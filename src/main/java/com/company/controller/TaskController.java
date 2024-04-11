package com.company.controller;

import com.company.dto.TaskDTO;
import com.company.service.ProjectService;
import com.company.service.TaskService;
import com.company.service.UserService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final UserService userService;
    private  final ProjectService projectService;
    private final TaskService taskService;

    public TaskController(UserService userService, ProjectService projectService, TaskService taskService) {
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createTask(Model model) {
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());
        return "/task/create";
    }

    @PostMapping("/create")
    public String insertTask(@ModelAttribute("task") TaskDTO taskDTO) {
        if (taskDTO.getId() == null) {
            taskDTO.setId(UUID.randomUUID().getMostSignificantBits());
        }
        taskService.save(taskDTO);
        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteButton(@PathVariable("id") Long id){
        taskService.deleteById(id);
        return "redirect:/task/create";
    }

    @GetMapping("/update/{id}")
    public String updateButton(@PathVariable("id") Long id, Model model){
        model.addAttribute("task",  taskService.findById(id));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());
        return "redirect:/task/update";
    }

    @PostMapping("/update/{taskId}")
    public String updateTask(@ModelAttribute("task") TaskDTO task, @PathVariable("taskId") Long taskId) {
        task.setId(taskId);
        taskService.update(task);
        return "redirect:/task/create";
    }


}

package com.company.controller;

import com.company.dto.UserDTO;
import com.company.service.RoleService;
import com.company.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final RoleService roleService;
    private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("roleList", roleService.findAll());
        model.addAttribute("userList", userService.findAll());
        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(Model model, @ModelAttribute("user") UserDTO userDTO) {
        userService.save(userDTO);

        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String updateButton(Model model, @PathVariable("username") String username) {
        model.addAttribute("roleList", roleService.findAll());
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("user", userService.findById(username));

        return "/user/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDTO userDTO) {
        userService.update(userDTO);
        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteButton(Model model, @PathVariable("username") String username) {
        userService.deleteById(username);
        return "redirect:/user/create";
    }
}

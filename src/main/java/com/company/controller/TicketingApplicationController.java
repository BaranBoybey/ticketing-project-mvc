package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketingApplicationController {

    @GetMapping("/")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/welcome")
    public String getWelcome() {
        return "welcome";
    }
}

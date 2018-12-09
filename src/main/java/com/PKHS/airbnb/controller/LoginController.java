package com.PKHS.airbnb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "home/login";
    }

    @PostMapping("/check-login")
    public String checkLogin() {
        return "";
    }
}

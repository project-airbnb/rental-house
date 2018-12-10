package com.PKHS.airbnb.controller;

import com.PKHS.airbnb.model.User;
import com.PKHS.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "home/login";
    }


    @GetMapping("/admin")
    public String admin() {
        return "home/admin";
    }

    @GetMapping("/403")
    public String accessDenid() {
        return "errors-403";
    }

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

}

package com.PKHS.airbnb.controller;

import com.PKHS.airbnb.model.User;
import com.PKHS.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String listUser(Model model) {
        Iterable<User> users = this.userService.findAll();
        model.addAttribute("users", users);
        return "user/list";
    }

}

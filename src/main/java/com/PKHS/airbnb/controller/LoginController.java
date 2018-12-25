package com.PKHS.airbnb.controller;

import com.PKHS.airbnb.model.Category;
import com.PKHS.airbnb.model.Role;
import com.PKHS.airbnb.model.User;
import com.PKHS.airbnb.repository.RoleRepository;
import com.PKHS.airbnb.service.CategoryService;
import com.PKHS.airbnb.service.CustomerRentalHouseService;
import com.PKHS.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@Controller
public class LoginController extends GetIdUserController{

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerRentalHouseService customerRentalHouseService;

    @GetMapping("/test")
    public String test(Model model) {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().
                getAuthentication().getPrincipal();
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getAuthorities());
        return "errors/test";
    }
    @GetMapping("/header")
    public String my_header(@ModelAttribute("myName") Integer id, Model model) {
        model.addAttribute("myName", id);
        return "fragments/header";
    }
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("rental_houses", this.customerRentalHouseService.findAll());
        model.addAttribute("categories", this.categoryService.findAll());
        return "home/index";
    }

    @GetMapping("/403")
    public String errors() {
        return "errors/403";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "forward:/user/create";
    }
}

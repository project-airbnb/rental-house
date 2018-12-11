package com.PKHS.airbnb.controller;

import com.PKHS.airbnb.model.PostRent;
import com.PKHS.airbnb.service.PostRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostRentController {
    @Autowired
    private PostRentService postRentService;

    @GetMapping
    public String PostController(Model model) {
        Iterable<PostRent> postRents = this.postRentService.findAll();
        model.addAttribute("postRents", postRents);
        return "post-rent/list";
    }


}

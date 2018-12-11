package com.PKHS.airbnb.controller;

import com.PKHS.airbnb.model.PostRent;
import com.PKHS.airbnb.service.PostRentService;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/delete-post-rent/{id}")
    public String deletePost(@PathVariable("id") int id, RedirectAttributes attributes) {
        if (this.postRentService.findById(id) != null) {
            this.postRentService.remove(id);
            attributes.addFlashAttribute("message", "Delete Successful");
            return "redirect:/post";
        }
        return "redirect:/errors-403";
    }

    @GetMapping("/edit-post-rent/{id}")
    public String editPost(@PathVariable("id") int id, Model model) {
        PostRent post = this.postRentService.findById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "post-rent/edit";
        }
        return "errors-403";
    }

    @PostMapping("/edit-post-rent")
    public String updatePost(@ModelAttribute("post") PostRent post, RedirectAttributes attributes) {
        this.postRentService.save(post);
        attributes.addFlashAttribute("message", "Update post successful");
        return "redirect:/post";
    }

    @GetMapping("/add-post-rent")
    public String addPost(Model model) {
        PostRent post = new PostRent();
        model.addAttribute("post", post);
        return "post-rent/add";
    }

    @PostMapping("/add-post-rent")
    public String savePost(@ModelAttribute("post") PostRent post, RedirectAttributes attributes) {
        this.postRentService.save(post);
        attributes.addFlashAttribute("message", "Create post successfull");
        return "redirect:/post";
    }
}

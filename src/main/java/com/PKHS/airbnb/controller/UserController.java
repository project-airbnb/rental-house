package com.PKHS.airbnb.controller;

import com.PKHS.airbnb.model.User;
import com.PKHS.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView viewHome(@RequestParam("s") Optional<String> s,@PageableDefault(size=5) Pageable pageable) {
        Page<User> users;
        if(s.isPresent()) {
            users = userService.findByName(s.get(),pageable);
        }else {
            users= userService.fillAll(pageable);
        }
        ModelAndView modelAndView= new ModelAndView("user/view");
        modelAndView.addObject("users",users);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView viewDelete(@PathVariable("id") Integer id,User user) {
        ModelAndView modelAndView=new ModelAndView("delete");
        modelAndView.addObject("user",userService.findById(id));
        return modelAndView;
    }
   @PostMapping("/delete")
    public ModelAndView deleteUser(@RequestParam Integer id,User user) {
        user=userService.findById(id);
        if(user !=null) {
            userService.remove(id);
            ModelAndView modelAndView=new ModelAndView("delete");
            modelAndView.addObject("delete","delete successfully");
            return modelAndView;
        }else {
            ModelAndView modelAndView= new ModelAndView("delete");
            modelAndView.addObject("delete","Not User delete..");
            return modelAndView;
        }
    }
    @GetMapping("/edit/{id}")
    public ModelAndView viewEdit(@PathVariable("id") Integer id, User user){
        ModelAndView modelAndView= new ModelAndView("edit");
        modelAndView.addObject("user",userService.findById(id));
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView editUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        ModelAndView modelAndView= new ModelAndView("edit");
        if(bindingResult.hasFieldErrors()) {
            return modelAndView;
        }else {
            userService.save(user);
            modelAndView.addObject("message","user updated successfully");
            return modelAndView;
        }
    }

}

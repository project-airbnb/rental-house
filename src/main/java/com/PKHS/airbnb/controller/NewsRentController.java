package com.PKHS.airbnb.controller;

import com.PKHS.airbnb.model.NewsRent;
import com.PKHS.airbnb.service.NewsRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class NewsRentController {
    @Autowired
    NewsRentService newsRentService;
    @GetMapping("new-rent")
    public ModelAndView listNewsrents(@RequestParam("s")Optional<String> s, Pageable pageable) {
        Page<NewsRent> newsRents;
        if(s.isPresent()) {
            newsRents = newsRentService.findAllByTitleContaining(s.get(), pageable);
        } else {
            newsRents = newsRentService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("new-rent/listNewsRent");
        modelAndView.addObject("newsRents", newsRents);
        return modelAndView;
    }
}

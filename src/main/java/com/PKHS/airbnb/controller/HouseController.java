package com.PKHS.airbnb.controller;

import com.PKHS.airbnb.model.House;
import com.PKHS.airbnb.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @GetMapping
    public ModelAndView showListHousesForm(@RequestParam("price")Optional<String> price, Pageable pageable) {
        Page<House> houses;
        if(price.isPresent()) {
            houses = houseService.findAllByPriceContaining(price, pageable);
        } else {
            houses = houseService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("house/list");
        modelAndView.addObject("houses", houses);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showHouseDetail(@PathVariable Integer id) {
        House house = houseService.findById(id);
        ModelAndView modelAndView = new ModelAndView("house/viewDetail");
        modelAndView.addObject("house", house);
        return modelAndView;
    }
}

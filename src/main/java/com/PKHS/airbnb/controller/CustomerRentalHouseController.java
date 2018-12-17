package com.PKHS.airbnb.controller;

import com.PKHS.airbnb.model.RentalHouse;
import com.PKHS.airbnb.service.CustomerRentalHouseService;
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
public class CustomerRentalHouseController {

    @Autowired
    private CustomerRentalHouseService customerRentalHouseService;

    @GetMapping
    public ModelAndView showListHousesForm(@RequestParam("price")Optional<String> price, Pageable pageable) {
        Page<RentalHouse> houses;
        if(price.isPresent()) {
            houses = customerRentalHouseService.findAllByPriceContaining(price, pageable);
        } else {
            houses = customerRentalHouseService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("house/list");
        modelAndView.addObject("houses", houses);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showHouseDetail(@PathVariable Integer id) {
        RentalHouse house = customerRentalHouseService.findById(id);
        ModelAndView modelAndView = new ModelAndView("house/viewDetail");
        modelAndView.addObject("house", house);
        return modelAndView;
    }
}

package com.PKHS.airbnb.service.impl;

import com.PKHS.airbnb.model.House;
import com.PKHS.airbnb.repository.HouseRepository;
import com.PKHS.airbnb.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    HouseRepository houseRepository;

    @Override
    public Page<House> findAll(Pageable pageable) {
        return this.houseRepository.findAll(pageable);
    }

    @Override
    public House findById(Integer id) {
        return this.houseRepository.findById(id).orElse(null);
    }

    @Override
    public void save(House house) {
        this.houseRepository.save(house);
    }

    @Override
    public void remove(Integer id) {
       this.houseRepository.deleteById(id);
    }

    @Override
    public Page<House> findAllByPriceContaining(Optional<String> price, Pageable pageable) {
       return this.houseRepository.findAllByPriceContaining(price, pageable);
    }
}

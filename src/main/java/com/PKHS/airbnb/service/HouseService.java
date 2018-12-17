package com.PKHS.airbnb.service;

import com.PKHS.airbnb.model.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface HouseService {
    Page<House> findAll(Pageable pageable);

    House findById(Integer id);

    void save(House house);

    void remove(Integer id);

    Page<House> findAllByPriceContaining(Optional<String> price, Pageable pageable);
}

package com.PKHS.airbnb.repository;

import com.PKHS.airbnb.model.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public interface HouseRepository extends PagingAndSortingRepository<House, Integer> {
    Page<House> findAllByPriceContaining(Optional<String> price, Pageable pageable);
}

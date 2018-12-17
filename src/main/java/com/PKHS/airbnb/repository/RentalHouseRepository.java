package com.PKHS.airbnb.repository;

import com.PKHS.airbnb.model.RentalHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public interface RentalHouseRepository extends PagingAndSortingRepository<RentalHouse, Integer> {
    Page<RentalHouse> findAllByPriceContaining(Optional<String> price, Pageable pageable);
}

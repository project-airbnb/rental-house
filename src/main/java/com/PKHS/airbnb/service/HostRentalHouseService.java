package com.PKHS.airbnb.service;

import com.PKHS.airbnb.model.RentalHouse;

public interface HostRentalHouseService {
    Iterable<RentalHouse> findAll();

    RentalHouse findById(Integer id);

    void save(RentalHouse post);

    void remove(Integer id);

    Iterable<RentalHouse> findAllByUserId(Iterable<Integer> ids);
}

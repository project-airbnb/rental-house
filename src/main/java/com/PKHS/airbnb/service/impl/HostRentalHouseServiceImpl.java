package com.PKHS.airbnb.service.impl;

import com.PKHS.airbnb.model.RentalHouse;
import com.PKHS.airbnb.repository.RentalHouseRepository;
import com.PKHS.airbnb.service.HostRentalHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostRentalHouseServiceImpl implements HostRentalHouseService {
    @Autowired
    private RentalHouseRepository rentalHouseRepository;

    @Override
    public Iterable<RentalHouse> findAll() {
        return this.rentalHouseRepository.findAll();
    }

    @Override
    public RentalHouse findById(Integer id) {
        return this.rentalHouseRepository.findById(id).orElse(null);
    }

    @Override
    public void save(RentalHouse post) {
        this.rentalHouseRepository.save(post);
    }

    @Override
    public void remove(Integer id) {
        this.rentalHouseRepository.deleteById(id);
    }

    @Override
    public Iterable<RentalHouse> findAllByUserId(Iterable<Integer> ids) {
        return this.rentalHouseRepository.findAllById(ids);
    }
}

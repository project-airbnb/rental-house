package com.PKHS.airbnb.service;

import com.PKHS.airbnb.model.Customer;

public interface CustomerService {

    Iterable<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

}

package com.PKHS.airbnb.service.impl;

import com.PKHS.airbnb.model.Customer;
import com.PKHS.airbnb.repository.CustomerRepository;
import com.PKHS.airbnb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return this.customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        this.customerRepository.deleteById(id);
    }
}

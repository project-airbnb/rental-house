package com.PKHS.airbnb.service.impl;

import com.PKHS.airbnb.model.User;
import com.PKHS.airbnb.repository.UserRepository;
import com.PKHS.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void remove(Integer id) {
        this.userRepository.deleteById(id);
    }
}

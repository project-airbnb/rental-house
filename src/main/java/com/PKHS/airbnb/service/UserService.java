package com.PKHS.airbnb.service;

import com.PKHS.airbnb.model.User;

public interface UserService {

    Iterable<User> findAll();

    User findById(Integer id);

    void save(User user);

    void remove(Integer id);

}

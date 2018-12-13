package com.PKHS.airbnb.service;

import com.PKHS.airbnb.model.PostRent;

public interface PostRentService {
    Iterable<PostRent> findAll();

    PostRent findById(Integer id);

    void save(PostRent post);

    void remove(Integer id);

    Iterable<PostRent> findAllByUserId(Iterable<Integer> ids);
}

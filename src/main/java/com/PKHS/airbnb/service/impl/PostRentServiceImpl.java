package com.PKHS.airbnb.service.impl;

import com.PKHS.airbnb.model.PostRent;
import com.PKHS.airbnb.repository.PostRentRepository;
import com.PKHS.airbnb.service.PostRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostRentServiceImpl implements PostRentService {
    @Autowired
    private PostRentRepository postRentRepository;

    @Override
    public Iterable<PostRent> findAll() {
        return this.postRentRepository.findAll();
    }

    @Override
    public PostRent findById(Integer id) {
        return this.postRentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(PostRent post) {
        this.postRentRepository.save(post);
    }

    @Override
    public void remove(Integer id) {
        this.postRentRepository.deleteById(id);
    }

    @Override
    public Iterable<PostRent> findAllByUserId(Iterable<Integer> ids) {
        return this.postRentRepository.findAllById(ids);
    }
}

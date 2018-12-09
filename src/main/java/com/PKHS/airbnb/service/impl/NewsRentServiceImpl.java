package com.PKHS.airbnb.service.impl;

import com.PKHS.airbnb.model.NewsRent;
import com.PKHS.airbnb.repository.NewsRentRepository;
import com.PKHS.airbnb.service.NewsRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsRentServiceImpl implements NewsRentService {

    @Autowired
    NewsRentRepository newsRentRepository;

    @Override
    public Iterable<NewsRent> findAll() {
        return this.newsRentRepository.findAll();
    }

    @Override
    public NewsRent findById(Integer id) {
        return this.newsRentRepository.findById(id).get();
    }

    @Override
    public void save(NewsRent news) {
        this.newsRentRepository.save(news);
    }

    @Override
    public void remove(Integer id) {
        this.newsRentRepository.deleteById(id);
    }
}

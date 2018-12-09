package com.PKHS.airbnb.service;

import com.PKHS.airbnb.model.NewsRent;

public interface NewsRentService {
    Iterable<NewsRent> findAll();

    NewsRent findById(Integer id);

    void save(NewsRent news);

    void remove(Integer id);
}

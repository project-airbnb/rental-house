package com.PKHS.airbnb.service.impl;

import com.PKHS.airbnb.model.NewsRent;
import com.PKHS.airbnb.repository.NewsRentRepository;
import com.PKHS.airbnb.service.NewsRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NewsRentServiceImpl implements NewsRentService {

    @Autowired
    NewsRentRepository newsRentRepository;

    @Override
    public Page<NewsRent> findAll(Pageable pageable) {
        return newsRentRepository.findAll(pageable);
    }

    @Override
    public Page<NewsRent> findAllByTitleContaining(String title, Pageable pageable) {
        return newsRentRepository.findAllByTitleContaining(title, pageable);
    }


}

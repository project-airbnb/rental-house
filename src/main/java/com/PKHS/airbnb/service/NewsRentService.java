package com.PKHS.airbnb.service;

import com.PKHS.airbnb.model.NewsRent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NewsRentService {
    Page<NewsRent> findAll(Pageable pageable);

    Page<NewsRent> findAllByTitleContaining(String title, Pageable pageable);
}

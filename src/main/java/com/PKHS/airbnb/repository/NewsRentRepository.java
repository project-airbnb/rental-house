package com.PKHS.airbnb.repository;

import com.PKHS.airbnb.model.NewsRent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRentRepository extends PagingAndSortingRepository<NewsRent, Integer> {
    Page<NewsRent> findAllByTitleContaining(String title, Pageable pageable);
}

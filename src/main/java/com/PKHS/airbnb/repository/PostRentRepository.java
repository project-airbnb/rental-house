package com.PKHS.airbnb.repository;

import com.PKHS.airbnb.model.PostRent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRentRepository extends PagingAndSortingRepository<PostRent, Integer> {
}

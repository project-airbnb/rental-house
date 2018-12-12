package com.PKHS.airbnb.repository;

import com.PKHS.airbnb.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Integer> {
    Page<User> findAllByUsernameContaining(String name, Pageable pageable);
}

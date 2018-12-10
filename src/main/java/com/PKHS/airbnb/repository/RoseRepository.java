package com.PKHS.airbnb.repository;

import com.PKHS.airbnb.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoseRepository extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}

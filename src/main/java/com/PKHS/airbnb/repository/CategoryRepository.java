package com.PKHS.airbnb.repository;

import com.PKHS.airbnb.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}

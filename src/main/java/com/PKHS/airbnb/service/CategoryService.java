package com.PKHS.airbnb.service;

import com.PKHS.airbnb.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void remove(Integer id);
}

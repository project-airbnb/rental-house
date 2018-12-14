package com.PKHS.airbnb.service.impl;

import com.PKHS.airbnb.model.Category;
import com.PKHS.airbnb.repository.CategoryRepository;
import com.PKHS.airbnb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {
        this.categoryRepository.deleteById(id);
    }
}

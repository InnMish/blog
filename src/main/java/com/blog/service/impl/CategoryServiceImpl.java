package com.blog.service.impl;

import com.blog.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import com.blog.repository.CategoryRepository;
import com.blog.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public Category editCategory(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Category findCategoryById(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getListCategories() {
        return categoryRepository.findAll();
    }
}

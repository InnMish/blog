package com.blog.service;

import com.blog.entity.Category;
import com.blog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    public Category editCategory(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    public void deleteCategory(long id) {
        categoryRepository.deleteCategoryById(id);
    }

    public Category findCategoryById(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name).orElse(null);
    }

    public List<Category> getListCategories() {
        return categoryRepository.findAll();
    }
}

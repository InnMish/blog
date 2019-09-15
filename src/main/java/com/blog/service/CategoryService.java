package com.blog.service;

import com.blog.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);
    Category editCategory(Category category);
    void deleteCategory(Category category);
    Category findCategoryById(long id);
    List<Category> getListCategories();
}

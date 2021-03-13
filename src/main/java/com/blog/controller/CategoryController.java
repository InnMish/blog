package com.blog.controller;

import com.blog.entity.Category;
import com.blog.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "Category", tags = {"Category"})
public class CategoryController {
    private final CategoryService categoryService;

    @ApiOperation(value = "Create category", tags = {"Category"})
    @PostMapping(value = "/create/category")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @ApiOperation(value = "Edit category", tags = {"Category"})
    @PutMapping(value = "/edit/category")
    public Category editCategory(@RequestBody Category category) {
        return categoryService.editCategory(category);
    }

    @Transactional
    @ApiOperation(value = "Delete category", tags = {"Category"})
    @DeleteMapping(value = "/delete/category/{id}")
    public void deleteCategory(@PathVariable("id") long id) {
        categoryService.deleteCategory(id);
    }

    @ApiOperation(value = "Get all categories", tags = {"Category"})
    @GetMapping(value = "/categories")
    public List<Category> getCategories() {
        return categoryService.getListCategories();
    }

    @Transactional
    @ApiOperation(value = "Get category by id", tags = {"Category"})
    @GetMapping(value = "/search/category/{id}")
    public Category getCategoryById(@PathVariable("id") long id) {
        return categoryService.findCategoryById(id);
    }

    @Transactional
    @ApiOperation(value = "Get category by name", tags = {"Category"})
    @GetMapping(value = "/search/category/name/{name}")
    public Category getCategoryByName(@PathVariable("name") String name) {
        return categoryService.findCategoryByName(name);
    }
}

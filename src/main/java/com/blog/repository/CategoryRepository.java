package com.blog.repository;

import com.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    void deleteCategoryById(long id);

    Optional<Category> findCategoryByName(String name);

    Category findCategoryById(long id);
}

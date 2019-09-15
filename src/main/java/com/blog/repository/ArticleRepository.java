package com.blog.repository;

import com.blog.entity.Article;
import com.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "SELECT * FROM article WHERE name = :name", nativeQuery = true)
    Optional<Article> findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM article WHERE category = :category", nativeQuery = true)
    List<Article> findByCategory(@Param("category") Category category);
}

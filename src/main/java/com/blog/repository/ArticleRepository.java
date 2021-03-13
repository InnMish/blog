package com.blog.repository;

import com.blog.entity.Article;
import com.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<Article> findArticleByName(String name);

    List<Article> findArticleByCategoryName(String name);

    void deleteArticleById(long id);
}

package com.blog.service;

import com.blog.entity.Article;
import com.blog.entity.Category;

import java.util.List;

public interface ArticleService {

    Article createArticle(Article article);
    Article editArticle(Article article);
    void deleteArticle(Article article);
    List<Article> getListArticles();
    Article findArticleById(long id);
    Article findArticleByName(String name);

    //maybe add search by category
    List<Article> getArticlesByCategory(Category category);
}

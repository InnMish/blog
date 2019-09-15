package com.blog.service.impl;

import com.blog.entity.Article;
import com.blog.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import com.blog.repository.ArticleRepository;
import com.blog.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article createArticle(Article article) {
        return articleRepository.saveAndFlush(article);
    }

    @Override
    public Article editArticle(Article article) {
        return articleRepository.saveAndFlush(article);
    }

    @Override
    public void deleteArticle(Article article) {
        articleRepository.delete(article);
    }

    @Override
    public List<Article> getListArticles() {
        return articleRepository.findAll();
    }

    //maybe superfluous
    @Override
    public Article findArticleById(long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public Article findArticleByName(String name) {
        return articleRepository.findByName(name).orElse(null);
    }

    @Override
    public List<Article> getArticlesByCategory(Category category) {
        return articleRepository.findByCategory(category);
    }
}

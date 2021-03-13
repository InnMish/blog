package com.blog.service;

import com.blog.entity.Article;
import com.blog.entity.Category;
import com.blog.repository.ArticleRepository;
import com.blog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public Article createArticle(Article article) {
        Category categoryOfArticle = categoryRepository.findCategoryById(article.getCategory().getId());
        article.setCategory(categoryOfArticle);
        return articleRepository.saveAndFlush(article);
    }

    public Article editArticle(Article article) {
        return articleRepository.saveAndFlush(article);
    }

    public void deleteArticle(long id) {
        articleRepository.deleteArticleById(id);
    }

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    //maybe superfluous
    public Article findArticleById(long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article findArticleByName(String name) {
        return articleRepository.findArticleByName(name).orElse(null);
    }

    public List<Article> getArticlesByCategoryName(String name) {
        return articleRepository.findArticleByCategoryName(name);
    }
}

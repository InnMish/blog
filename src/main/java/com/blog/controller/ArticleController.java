package com.blog.controller;

import com.blog.entity.Article;
import com.blog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "Article", tags = {"Article"})
public class ArticleController {

    private final ArticleService articleService;

    @ApiOperation(value = "Get all articles", tags = {"Article"})
    @GetMapping(value = "/")
    public List<Article> getArticles() {
        return articleService.getArticles();
    }

    @ApiOperation(value = "Get article by id", tags = {"Article"})
    @GetMapping(value = "/search/{id}")
    public Article getArticle(@PathVariable("id") int id) {
        return articleService.findArticleById(id);
    }

    @ApiOperation(value = "Get article by name", tags = {"Article"})
    @GetMapping(value = "/search/name/{name}")
    public Article getArticleByName(@PathVariable("name") String name) {
        return articleService.findArticleByName(name);
    }

    @ApiOperation(value = "Get articles by category name", tags = {"Article"})
    @GetMapping(value = "/filter/{title}")
    public List<Article> getArticleByCategoryName(@PathVariable("title") String name) {
        return articleService.getArticlesByCategoryName(name);
    }

    @ApiOperation(value = "Create article", tags = {"Article"})
    @PostMapping(value = "/create")
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @ApiOperation(value = "Edit article", tags = {"Article"})
    @PutMapping(value = "/edit")
    public Article editArticle(@RequestBody Article article) {
        return articleService.editArticle(article);
    }

    @Transactional
    @ApiOperation(value = "Delete article", tags = {"Article"})
    @DeleteMapping(value = "/delete/{id}")
    public void deleteArticle(@PathVariable("id") long id) {
        articleService.deleteArticle(id);
    }
}

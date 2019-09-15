package com.blog.repository;

import com.blog.entity.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {

    @Query(value = "SELECT * FROM paragraph WHERE article_id = :articleId", nativeQuery = true)
    List<Paragraph> findParagraphsByArticleId(@Param("articleId") long id);
}

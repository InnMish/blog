package com.blog.repository;

import com.blog.entity.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {

    List<Paragraph> findParagraphByArticleId(long id);

    void deleteParagraphById(long id);
}

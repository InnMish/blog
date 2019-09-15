package com.blog.service;

import com.blog.entity.Paragraph;

import java.util.List;

public interface ParagraphService {

    Paragraph createParagraph(Paragraph paragraph);
    Paragraph editParagraph(Paragraph paragraph);
    void deleteParagraph(Paragraph paragraph);
    List<Paragraph> getAllParagraphs();
    List<Paragraph> getParagraphsByArticleId(long id);
    Paragraph findParagraphById(long id);
}

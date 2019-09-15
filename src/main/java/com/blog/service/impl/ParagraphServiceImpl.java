package com.blog.service.impl;

import com.blog.entity.Paragraph;
import org.springframework.beans.factory.annotation.Autowired;
import com.blog.repository.ParagraphRepository;
import com.blog.service.ParagraphService;

import java.util.List;

public class ParagraphServiceImpl implements ParagraphService {

    @Autowired
    private ParagraphRepository paragraphRepository;

    @Override
    public Paragraph createParagraph(Paragraph paragraph) {
        return paragraphRepository.saveAndFlush(paragraph);
    }

    @Override
    public Paragraph editParagraph(Paragraph paragraph) {
        return paragraphRepository.saveAndFlush(paragraph);
    }

    @Override
    public void deleteParagraph(Paragraph paragraph) {
        paragraphRepository.delete(paragraph);
    }

    @Override
    public List<Paragraph> getAllParagraphs() {
        return paragraphRepository.findAll();
    }

    @Override
    public List<Paragraph> getParagraphsByArticleId(long id) {
        return paragraphRepository.findParagraphsByArticleId(id);
    }

    @Override
    public Paragraph findParagraphById(long id) {
        return paragraphRepository.findById(id).orElse(null);
    }
}

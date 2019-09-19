package com.blog.service;

import com.blog.entity.Paragraph;
import com.blog.repository.ParagraphRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParagraphService {

    private final ParagraphRepository paragraphRepository;

    public Paragraph createParagraph(Paragraph paragraph) {
        return paragraphRepository.saveAndFlush(paragraph);
    }

    public Paragraph editParagraph(Paragraph paragraph) {
        return paragraphRepository.saveAndFlush(paragraph);
    }

    public void deleteParagraphById(long id) {
        paragraphRepository.deleteParagraphById(id);
    }

    public List<Paragraph> getAllParagraphs() {
        return paragraphRepository.findAll();
    }

    public List<Paragraph> getParagraphsByArticleId(long id) {
        return paragraphRepository.findParagraphByArticleId(id);
    }

    public Paragraph findParagraphById(long id) {
        return paragraphRepository.findById(id).orElse(null);
    }
}

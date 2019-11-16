package com.blog.controller;

import com.blog.entity.Paragraph;
import com.blog.service.ParagraphService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "Paragraph", tags = {"Paragraph"})
public class ParagraphController {

    private final ParagraphService paragraphService;

    @Transactional
    @ApiOperation(value = "Create paragraph", tags = {"Paragraph"})
    @PostMapping(value = "/create/paragraph")
    public Paragraph createParagraph(@RequestBody Paragraph paragraph, @RequestParam MultipartFile file) throws IOException {
        return paragraphService.createParagraph(paragraph, file);
    }

    @ApiOperation(value = "Edit paragraph", tags = {"Paragraph"})
    @PutMapping(value = "/edit/paragraph")
    public Paragraph editParagraph(@RequestBody Paragraph paragraph) {
        return paragraphService.editParagraph(paragraph);
    }

    @ApiOperation(value = "Delete paragraph", tags = {"Paragraph"})
    @DeleteMapping(value = "/delete/paragraph/{id}")
    public void deleteParagraph(@PathVariable("id") long id) {
        paragraphService.deleteParagraphById(id);
    }

    @ApiOperation(value = "Get all paragraphs", tags = {"Paragraph"})
    @GetMapping(value = "/paragraphs")
    public List<Paragraph> getParagraphs() {
        return paragraphService.getAllParagraphs();
    }

    @ApiOperation(value = "Get paragraphs by article id", tags = {"Paragraph"})
    @GetMapping(value = "/paragraphs/article/{id}")
    public List<Paragraph> getParagraphsByArticleId(@PathVariable("id") long id) {
        return paragraphService.getParagraphsByArticleId(id);
    }

    @ApiOperation(value = "Get paragraph by id", tags = {"Paragraph"})
    @GetMapping(value = "/paragraph/{id}")
    public Paragraph getParagraph(@PathVariable("id") long id) {
        return paragraphService.findParagraphById(id);
    }
}

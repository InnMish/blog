package com.blog.controller;

import com.blog.entity.Comment;
import com.blog.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(value = "Comment", tags = {"Comment"})
public class CommentController {

    private final CommentService commentService;

    @ApiOperation(value = "Create comment", tags = {"Comment"})
    @PostMapping(value = "/create/comment")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @ApiOperation(value = "Edit comment", tags = {"Comment"})
    @PutMapping(value = "/edit/comment")
    public Comment editComment(@RequestBody Comment comment) {
        return commentService.editComment(comment);
    }

    @ApiOperation(value = "Delete comment", tags = {"Comment"})
    @DeleteMapping(value = "/delete/comment/{id}")
    public void deleteComment(@PathVariable("id") long id) {
        commentService.deleteComment(id);
    }
}

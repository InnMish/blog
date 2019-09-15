package com.blog.service.impl;

import com.blog.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import com.blog.repository.CommentRepository;
import com.blog.service.CommentService;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }
}

package com.blog.service;

import com.blog.entity.Comment;
import com.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    public Comment editComment(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    public void deleteComment(long id) {
        commentRepository.deleteCommentById(id);
    }
}

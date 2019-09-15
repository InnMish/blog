package com.blog.service;

import com.blog.entity.Comment;

public interface CommentService {

    Comment createComment(Comment comment);
    void deleteComment(Comment comment);
}

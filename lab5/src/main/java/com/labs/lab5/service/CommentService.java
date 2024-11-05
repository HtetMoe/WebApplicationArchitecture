package com.labs.lab5.service;

import com.labs.lab5.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();

    Comment getCommentById(Long id);

    void createComment(Comment comment);

    void addComment(Comment comment);

}

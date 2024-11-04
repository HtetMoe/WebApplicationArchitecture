package com.labs.lab4.service.comment_service;
import com.labs.lab4.entity.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();

    Comment getCommentById(Long id);

    void createComment(Comment comment);

    void addComment(Comment comment);

}

package com.labs.lab5.service;

import com.labs.lab5.entity.Comment;
import com.labs.lab5.entity.dto.CommentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CommentService {
    Page<CommentDTO> getAllComments(Pageable pageable);

    Comment getCommentById(Long id);

    void createComment(Comment comment);

    void addComment(Comment comment);

}

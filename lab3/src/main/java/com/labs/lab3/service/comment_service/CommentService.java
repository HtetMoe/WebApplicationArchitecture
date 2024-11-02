package com.labs.lab3.service.comment_service;
import com.labs.lab3.entity.dto.CommentDTO;
import java.util.List;

public interface CommentService {
    List<CommentDTO> getAllComments();

    CommentDTO getCommentById(Long id);

    void createComment(CommentDTO commentDTO);
}

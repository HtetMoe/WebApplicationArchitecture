package com.labs.lab5.service.impl;
import com.labs.lab5.entity.Comment;
import com.labs.lab5.repository.CommentRepository;
import com.labs.lab5.service.CommentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));
    }

    @Override
    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }
}

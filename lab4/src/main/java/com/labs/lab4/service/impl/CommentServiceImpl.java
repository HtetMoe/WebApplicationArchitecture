package com.labs.lab4.service.impl;
import com.labs.lab4.entity.Comment;
import com.labs.lab4.entity.Post;
import com.labs.lab4.exception.ResourceNotFoundException;
import com.labs.lab4.repository.CommentRepository;
import com.labs.lab4.service.CommentService;
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
}

package com.labs.lab5.service.impl;
import com.labs.lab5.entity.Comment;
import com.labs.lab5.entity.dto.CommentDTO;
import com.labs.lab5.repository.CommentRepository;
import com.labs.lab5.service.CommentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

//    @Override
//    public Page<CommentDTO> getAllComments() {
//        return commentRepository.findAll();
//    }

    @Override
    public Page<CommentDTO> getAllComments(Pageable pageable) {
        return commentRepository.findAll(pageable)
                .map(comment -> modelMapper.map(comment, CommentDTO.class));
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

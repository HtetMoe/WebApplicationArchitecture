package com.labs.lab3.service.comment_service;

import com.labs.lab3.entity.Comment;
import com.labs.lab3.entity.dto.CommentDTO;
import com.labs.lab3.repository.comment_repo.CommentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CommentDTO> getAllComments() {
        return commentRepository
                .findAll().stream()
                .map(comment -> modelMapper.map(comment, CommentDTO.class))
                .toList();
    }

    @Override
    public CommentDTO getCommentById(Long id) {
        return modelMapper.map(commentRepository.findById(id)
                .orElse(null), CommentDTO.class);
    }

    @Override
    public void createComment(CommentDTO commentDTO) {
        commentRepository.save(modelMapper.map(commentDTO, Comment.class));
    }
}

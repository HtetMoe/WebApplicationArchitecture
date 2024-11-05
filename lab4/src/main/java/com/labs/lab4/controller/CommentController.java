package com.labs.lab4.controller;

import com.labs.lab4.entity.dto.CommentDTO;
import com.labs.lab4.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<CommentDTO> getComments() {
        return commentService.getAllComments()
                .stream().map(comment -> modelMapper.map(comment, CommentDTO.class))
                .toList();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CommentDTO getCommentById(@PathVariable Long id) {
        return modelMapper.map(commentService.getCommentById(id), CommentDTO.class);
    }
}

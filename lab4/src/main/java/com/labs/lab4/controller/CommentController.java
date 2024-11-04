package com.labs.lab4.controller;
import com.labs.lab4.entity.dto.CommentDTO;
import com.labs.lab4.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}

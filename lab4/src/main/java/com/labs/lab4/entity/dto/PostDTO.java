package com.labs.lab4.entity.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    @NotEmpty(message = "Title is required.")
    private Long id;
    private String title;
    private String content;
    private String author;
    private List<CommentDTO> comments;
}

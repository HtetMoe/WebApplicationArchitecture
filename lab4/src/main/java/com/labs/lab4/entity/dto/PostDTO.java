package com.labs.lab4.entity.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

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
}

package com.labs.lab5.entity.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

package com.labs.lab4.entity.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    @NotEmpty(message = "Title is required.")
    long id;
    String title;
    String content;
    String author;
}

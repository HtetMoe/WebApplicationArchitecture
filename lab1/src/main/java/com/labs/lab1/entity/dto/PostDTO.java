package com.labs.lab1.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
    private String title;
    private String content;
    private String author;

    public PostDTO() {}

    public PostDTO(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

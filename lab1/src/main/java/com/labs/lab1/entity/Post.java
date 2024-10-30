package com.labs.lab1.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    private long id;
    private String title;
    private String content;
    private String author;

    public Post(long id, String title, String content, String author) {
        this.id      = id;
        this.title   = title;
        this.content = content;
        this.author  = author;
    }
}

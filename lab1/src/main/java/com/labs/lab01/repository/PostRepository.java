package com.labs.lab01.repository;

import com.labs.lab01.entity.Post;

import java.util.Collection;
import java.util.List;

public interface PostRepository {
    List<Post> findAll();

    Post findById(long id);

    void save(Post post);

    void delete(long id);

    void update(long id, Post post);

    List<Post> findByAuthor(String author);

    List<Post> findByAuthorName(String author);
}

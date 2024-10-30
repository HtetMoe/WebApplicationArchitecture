package com.labs.lab1.repository;
import com.labs.lab1.entity.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();

    Post findById(long id);

    void save(Post post);

    void delete(long id);

    List<Post> findByAuthor(String author);
}

package com.labs.lab01.service;

import com.labs.lab01.entity.Post;
import com.labs.lab01.entity.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> findAll();

    PostDTO findById(long id);

    void save(PostDTO post);

    void delete(long id);

    void update(long id, PostDTO post);

    List<PostDTO> findByAuthor(String author);

    List<PostDTO> findByAuthorName(String author);
}

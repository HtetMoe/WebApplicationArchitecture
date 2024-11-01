package com.labs.lab2.service;


import com.labs.lab2.entity.dto.PostDTO;

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

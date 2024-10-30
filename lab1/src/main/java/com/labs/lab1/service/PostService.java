package com.labs.lab1.service;

import com.labs.lab1.entity.Post;
import com.labs.lab1.entity.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    Post getPostById(long id);

    void createPost(Post post);

    void updatePost(long id, Post post);

    void deletePost(long id);

    List<PostDTO> getPostsByAuthor(String author);
}

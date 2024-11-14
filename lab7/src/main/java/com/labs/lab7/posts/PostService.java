package com.labs.lab7.posts;

import java.util.List;

public interface PostService {
    List<Post> getPosts();
    Post getPost(Long id);
    Post createPost(Post post);
    Post updatePost(Long id, Post post);
    void deletePost(Long id);
}

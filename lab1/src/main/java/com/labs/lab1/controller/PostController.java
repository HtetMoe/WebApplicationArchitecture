package com.labs.lab1.controller;

import com.labs.lab1.entity.Post;
import com.labs.lab1.entity.dto.PostDTO;
import com.labs.lab1.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public void createPost(@RequestBody Post post) {
        postService.createPost(post);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable long id, @RequestBody Post post) {
        postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable long id) {
        postService.deletePost(id);
        return "Post with ID " + id + " deleted.";
    }

    @GetMapping("/filter")
    public List<PostDTO> getPostsByAuthor(@RequestParam String author) {
        return postService.getPostsByAuthor(author);
    }
}


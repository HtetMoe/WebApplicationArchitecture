package com.labs.lab7.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getPosts();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updatePost(@RequestBody Post post, @PathVariable Long id) {
        postService.updatePost(id, post);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}

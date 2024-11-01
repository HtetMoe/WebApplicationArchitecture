package com.labs.lab01.controller;
import com.labs.lab01.entity.dto.PostDTO;
import com.labs.lab01.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //get all post
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDTO> getPosts() {
        return postService.findAll();
    }

    //get post by id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable long id) {
        PostDTO postDTO = postService.findById(id);
        if(postDTO == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }
        return postDTO;
    }

    //create post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createPost(@RequestBody PostDTO postDTO) {
        postService.save(postDTO);
    }

    //update post
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void updatePost(@PathVariable long id, @RequestBody PostDTO postDTO) {
        postService.update(id, postDTO);
    }

    //delete post
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}") // @PathVariable(name = "id")
    public String deletePost(@PathVariable(name = "id") long id) {
        postService.delete(id);
        return "Post with ID " + id + " deleted.";
    }

    //get posts by author(search)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search")
    public List<PostDTO> getPostsByAuthor(@RequestParam String author) {
        return postService.findByAuthor(author);
    }

    //get posts by author name
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter")
    public List<PostDTO> getPostsByAuthorName(@RequestParam String author) {
        return postService.findByAuthorName(author);
    }
}

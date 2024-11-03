package com.labs.lab4.controller;
import com.labs.lab4.entity.dto.CommentDTO;
import com.labs.lab4.entity.dto.PostDTO;
import com.labs.lab4.service.posts_service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.lang.StringTemplate.STR;

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
            throw new RuntimeException("Post not found!");
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
        return STR."Post with ID \{id} deleted.";
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

    //Lab3 : 5. Make it possible to add a comment that will be associated with its post.
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{postId}/addComment")
    public void addComment(@PathVariable long postId, @RequestBody CommentDTO commentDTO) {
        postService.addCommentToPost(postId, commentDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findByTitle/{title}")
    public List<PostDTO> findPostByTitle(@RequestParam String title) {
        return postService.findByTitle(title);
    }
}

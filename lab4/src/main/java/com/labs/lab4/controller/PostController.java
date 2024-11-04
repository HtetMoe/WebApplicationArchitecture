package com.labs.lab4.controller;
import com.labs.lab4.entity.Comment;
import com.labs.lab4.entity.Post;
import com.labs.lab4.entity.dto.CommentDTO;
import com.labs.lab4.entity.dto.PostDTO;
import com.labs.lab4.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static java.lang.StringTemplate.STR;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;
    private final ModelMapper modelMapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.findAll()
                .stream().map(post -> modelMapper.map(post, PostDTO.class))
                .toList();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable long id) {
        return  modelMapper.map(postService.findById(id), PostDTO.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createPost(@RequestBody PostDTO postDTO) {
        postService.save(modelMapper.map(postDTO, Post.class));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void updatePost(@PathVariable long id, @RequestBody PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        postService.update(id, post);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}") // @PathVariable(name = "id")
    public String deletePost(@PathVariable(name = "id") long id) {
        postService.delete(id);
        return STR."Post with ID \{id} deleted.";
    }

    //-----------------------------

    //get posts by authorName (filter)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter")
    public List<PostDTO> getPostsByAuthor(@RequestParam String author) {
        return postService.filterPostsByAuthor(author)
                .stream().map(post -> modelMapper.map(post, PostDTO.class))
                .toList();
    }

    //get posts by author text (search)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search")
    public List<PostDTO> getPostsByAuthorName(@RequestParam String text) {
        return postService.searchPostsByAuthorNameContaining(text)
                .stream().map(post -> modelMapper.map(post, PostDTO.class))
                .toList();
    }

    //Lab3 : 5. Make it possible to add a comment that will be associated with its post.
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{postId}/addComment")
    public void addComment(@PathVariable long postId, @RequestBody CommentDTO commentDTO) {
        postService.addCommentToPost(postId, modelMapper.map(commentDTO, Comment.class));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findByTitle/{title}")
    public List<PostDTO> findPostsByTitle(@RequestParam String title) {
        return postService.findPostsByTitle(title)
                .stream().map(post -> modelMapper.map(post, PostDTO.class))
                .toList();
    }
}

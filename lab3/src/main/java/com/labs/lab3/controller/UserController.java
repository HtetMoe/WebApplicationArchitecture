package com.labs.lab3.controller;

import com.labs.lab3.entity.Comment;
import com.labs.lab3.entity.Post;
import com.labs.lab3.entity.dto.CommentDTO;
import com.labs.lab3.entity.dto.PostDTO;
import com.labs.lab3.entity.dto.UserDTO;
import com.labs.lab3.service.users_service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.StringTemplate.STR;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    //get all users
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    // get user by id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    // create a new user
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createUser(@RequestBody UserDTO userDto) {
        userService.save(userDto);
    }

    //delete user
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.delete(id);
        return STR."User with id \{id} was deleted";
    }

    //get posts by userID
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/posts")
    public List<PostDTO> getPostsByUserId(@PathVariable Long id) {
        return userService.getPostsByUserId(id);
    }

    //users with more than one posts
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usersWithMultiplePosts")
    public List<UserDTO> getUsersWithMoreThanOnePost() {
        return userService.getUsersWithMoreThanOnePost();
    }

    //users that made posts with a specific title
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/title")
    List<UserDTO> findUsersByPostTitle(@RequestParam String title) {
        return userService.findUsersByPostTitle(title);
    }

    //10. navigate user to post, then to comment
    //(i.e : retrieve a specific comment for a specific post by a specific user)
    public CommentDTO getCommentByUserPostAndCommentId(@PathVariable long userId,
                                                       @PathVariable long postID,
                                                       @PathVariable long commentId) {

        UserDTO userDTO = userService.findById(userId);
        Post post = userDTO.getPosts().stream().map(p -> modelMapper.map(p, Post.class))
                .filter(p -> p.getId() == postID)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comment c = post.getComments()
                .stream().filter(comment -> comment.getId() == commentId)
                .findFirst().orElse(null);

        return modelMapper.map(c, CommentDTO.class);
    }
}

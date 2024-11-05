package com.labs.lab4.controller;
import com.labs.lab4.entity.Comment;
import com.labs.lab4.entity.User;
import com.labs.lab4.entity.dto.CommentDTO;
import com.labs.lab4.entity.dto.PostDTO;
import com.labs.lab4.entity.dto.UserDTO;
import com.labs.lab4.service.CommentService;
import com.labs.lab4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final CommentService commentService;
    private final ModelMapper modelMapper;

    //get all users
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers()
                .stream().map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    // get user by id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return modelMapper.map(userService.findById(id), UserDTO.class);
    }

    // create a new user
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createUser(@RequestBody UserDTO userDto) {
        userService.save(modelMapper.map(userDto, User.class));
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
        return userService.getPostsByUserId(id)
                .stream().map(post -> modelMapper.map(post, PostDTO.class))
                .toList();
    }

    //users with more than one posts
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usersWithMultiplePosts")
    public List<UserDTO> getUsersWithMoreThanNPosts(@RequestParam int postCount) {
        return userService.getUsersWithMoreThanNPosts(postCount)
                .stream().map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    //users that made posts with a specific title
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/title")
    List<UserDTO> findUsersByPostTitle(@RequestParam String title) {
        return userService.findUsersByPostTitle(title)
                .stream().map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    //10. navigate user to post, then to comment
    //(i.e : retrieve a specific comment for a specific post by a specific user)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
    public CommentDTO getCommentByUserPostAndCommentId(@PathVariable(value = "userId") Long userId,
                                                       @PathVariable(value = "postId") Long postID,
                                                       @PathVariable(value = "commentId") Long commentId) {
        Comment comment = userService.findCommentByUserIdAndPostIdAndCommentId(userId, postID, commentId);
        return modelMapper.map(comment, CommentDTO.class);
    }
}

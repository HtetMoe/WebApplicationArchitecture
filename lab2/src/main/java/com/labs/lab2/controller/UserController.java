package com.labs.lab2.controller;

import com.labs.lab2.entity.User;
import com.labs.lab2.entity.dto.PostDTO;
import com.labs.lab2.entity.dto.UserDto;
import com.labs.lab2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createUser(@RequestBody UserDto userDto){
        userService.save(userDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id){
        userService.delete(id);
        return STR."User with id \{id} was deleted";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/posts")
    public List<PostDTO> getPostsByUserId(@PathVariable Long id){
        return userService.getPostsByUserId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usersWithMultiplePosts")
    public List<UserDto> getUsersWithMoreThanOnePost(){
        return userService.getUsersWithMoreThanOnePost();
    }
}

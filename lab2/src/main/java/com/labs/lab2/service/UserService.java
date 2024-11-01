package com.labs.lab2.service;
import com.labs.lab2.entity.Post;
import com.labs.lab2.entity.dto.PostDTO;
import com.labs.lab2.entity.dto.UserDto;
import java.util.List;

public interface UserService {
    List<UserDto> getUsers();

    UserDto findById(long id);

    void save(UserDto userDto);

    void delete(long id);

    List<PostDTO> getPostsByUserId(long userId);

    //List<UserDto> getUsersWithMoreThanOnePost();
}

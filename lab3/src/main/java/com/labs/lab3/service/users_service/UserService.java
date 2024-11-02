package com.labs.lab3.service.users_service;
import com.labs.lab3.entity.dto.PostDTO;
import com.labs.lab3.entity.dto.UserDTO;
import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();

    UserDTO findById(long id);

    void save(UserDTO userDto);

    void delete(long id);

    List<PostDTO> getPostsByUserId(long userId);

    List<UserDTO> getUsersWithMoreThanOnePost();

    List<UserDTO> findUsersByPostTitle(String title);
}

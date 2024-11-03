package com.labs.lab4.service.users_service;
import com.labs.lab4.aspect.ExecutionTime;
import com.labs.lab4.entity.User;
import com.labs.lab4.entity.dto.PostDTO;
import com.labs.lab4.entity.dto.UserDTO;
import com.labs.lab4.repository.users_repo.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDTO> getUsers() {
        return userRepository
                .findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    @Override
    @ExecutionTime // => apply the ExecutionTime annotation
    public UserDTO findById(long id) {
        UserDTO userDTO = userRepository
                .findById(id)
                .map(user -> modelMapper.map(user, UserDTO.class))
                .orElse(null);
        if (userDTO == null)
            throw new RuntimeException("User not found!");

        return userDTO;
    }

    @Override
    public void save(UserDTO userDto) {
        userRepository.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<PostDTO> getPostsByUserId(long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null)
            throw new RuntimeException("User not found!");
        else
            return user.getPosts()
                    .stream()
                    .map(post -> modelMapper.map(post, PostDTO.class))
                    .toList();
    }

    @Override
    public List<UserDTO> getUsersWithMoreThanOnePost() {
        return userRepository.findUsersWithMoreThanPosts(1)
                .stream().map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    @Override
    public List<UserDTO> findUsersByPostTitle(String title) {
        return userRepository.findUsersByPostTitle(title)
                .stream().map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }
}
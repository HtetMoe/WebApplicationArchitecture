package com.labs.lab2.service;

import com.labs.lab2.entity.User;
import com.labs.lab2.entity.dto.PostDTO;
import com.labs.lab2.entity.dto.UserDto;
import com.labs.lab2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDto> getUsers() {
        return userRepository
                .findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
    }

    @Override
    public UserDto findById(long id) {
        return userRepository
                .findById(id)
                .map(user -> modelMapper.map(user, UserDto.class))
                .orElse(null);
    }

    @Override
    public void save(UserDto userDto) {
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

//    @Override
//    public List<UserDto> getUsersWithMoreThanOnePost() {
//        return userRepository.findByPostsSizeGreaterThan(1)
//                .stream().map(user -> modelMapper.map(user, UserDto.class))
//                .toList();
//    }
}

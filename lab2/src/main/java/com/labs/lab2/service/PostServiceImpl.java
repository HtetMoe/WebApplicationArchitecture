package com.labs.lab2.service;
import com.labs.lab2.entity.Post;
import com.labs.lab2.entity.dto.PostDTO;
import com.labs.lab2.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.StringTemplate.STR;


@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> findAll() {
        return postRepository.findAll().stream().map(post -> modelMapper.map(post, PostDTO.class)).toList();
    }

    @Override
    public PostDTO findById(long id) {
        return modelMapper.map(postRepository.findById(id), PostDTO.class);
    }

    @Override
    public void save(PostDTO post) {
        postRepository.save(modelMapper.map(post, Post.class));
    }

    @Override
    public void delete(long id) {
        Post post = postRepository.findById(id);
        if (post == null)
            throw new RuntimeException(STR."Post id :\{id} not found!");
        postRepository.delete(id);
    }

    @Override
    public void update(long id, PostDTO post) {
        postRepository.update(id, modelMapper.map(post, Post.class));
    }

    @Override
    public List<PostDTO> findByAuthor(String author) {
        return postRepository.findByAuthor(author)
                .stream()
                .map(post -> modelMapper.map(post, PostDTO.class)).toList();

    }

    @Override
    public List<PostDTO> findByAuthorName(String author) {
        return postRepository.findByAuthorName(author)
                .stream()
                .map(post -> modelMapper.map(post, PostDTO.class)).toList();
    }
}

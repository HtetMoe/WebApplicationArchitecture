package com.labs.lab4.service.posts_service;
import com.labs.lab4.entity.Comment;
import com.labs.lab4.entity.Post;
import com.labs.lab4.entity.dto.CommentDTO;
import com.labs.lab4.entity.dto.PostDTO;
import com.labs.lab4.repository.posts_repo.PostRepository;
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

    //5. Make it possible to add a comment that will be associated with its post.
    @Override
    public void addCommentToPost(long postId, CommentDTO comment) {
        Post post = postRepository.findById(postId);
        if (post == null)
            throw new RuntimeException("Post not found!");
        else
            post.getComments().add(modelMapper.map(comment, Comment.class));
    }

    @Override
    public List<PostDTO> findByTitle(String title) {
        return postRepository.findByTitle(title)
                .stream().map(post -> modelMapper.map(post, PostDTO.class))
                .toList();
    }


}

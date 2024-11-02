package com.labs.lab3.service.posts_service;
import com.labs.lab3.entity.dto.CommentDTO;
import com.labs.lab3.entity.dto.PostDTO;
import java.util.List;

public interface PostService {
    List<PostDTO> findAll();

    PostDTO findById(long id);

    void save(PostDTO post);

    void delete(long id);

    void update(long id, PostDTO post);

    List<PostDTO> findByAuthor(String author);

    List<PostDTO> findByAuthorName(String author);

    void addCommentToPost(long postId, CommentDTO comment);

    List<PostDTO> findByTitle(String title);
}

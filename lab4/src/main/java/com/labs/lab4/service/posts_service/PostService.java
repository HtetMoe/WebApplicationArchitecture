package com.labs.lab4.service.posts_service;
import com.labs.lab4.entity.Comment;
import com.labs.lab4.entity.Post;
import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post findById(long id);

    void save(Post post);

    void delete(long id);

    void update(long id, Post post);

    List<Post> filterPostsByAuthor(String author);

    List<Post> searchPostsByAuthorNameContaining(String author);

    void addCommentToPost(long postId, Comment comment);

    List<Post> findPostsByTitle(String title);
}

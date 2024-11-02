package com.labs.lab3.repository.posts_repo;
import com.labs.lab3.entity.Post;
import java.util.List;

public interface PostRepository {
    List<Post> findAll();

    Post findById(long id);

    void save(Post post);

    void delete(long id);

    void update(long id, Post post);

    List<Post> findByAuthor(String author);

    List<Post> findByAuthorName(String author);

    List<Post> findByTitle(String title);

}

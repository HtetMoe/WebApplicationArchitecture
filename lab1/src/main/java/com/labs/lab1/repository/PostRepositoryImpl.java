package com.labs.lab1.repository;

import com.labs.lab1.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository{
    private List<Post> posts = new ArrayList<>();
    private long currentPostID = 1;

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(long id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post post) {
        post = new Post(currentPostID++, post.getTitle(), post.getContent(), post.getAuthor());
        posts.add(post);
    }

    @Override
    public void delete(long id) {
        posts.removeIf(post -> post.getId() == id);
    }

    @Override
    public List<Post> findByAuthor(String author) {
        return posts.stream()
                .filter(post -> post.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .toList();
    }
}

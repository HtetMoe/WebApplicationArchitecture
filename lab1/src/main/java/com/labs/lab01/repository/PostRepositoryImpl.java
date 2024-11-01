package com.labs.lab01.repository;

import com.labs.lab01.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
/*
    - is a DAOs (Data Access Object) that access the database directly.
    - repository does all the operations related to the database.
*/
public class PostRepositoryImpl implements PostRepository {
    private List<Post> posts = new ArrayList<>();
    private long postId = 1;

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
        post.setId(postId++);
        posts.add(post);
        System.out.println("Saved Post!" + post.getAuthor());
    }

    @Override
    public void delete(long id) {
        posts.removeIf(post -> post.getId() == id);
    }

    @Override
    public void update(long id, Post post) {
        Post toUpdate = findById(id);
        toUpdate.setTitle(post.getTitle());
        toUpdate.setContent(post.getContent());
        toUpdate.setAuthor(post.getAuthor());
    }

    //all the posts that contains a ‘text’ in the ‘author’
    @Override
    public List<Post> findByAuthor(String author) {
        return posts
                .stream()
                .filter(post -> post.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .toList();
    }

    //(g) will retrieve all Posts made by an ‘author’
    @Override
    public List<Post> findByAuthorName(String author) {
        return posts
                .stream()
                .filter(post -> post.getAuthor().equalsIgnoreCase(author))
                .toList();
    }
}

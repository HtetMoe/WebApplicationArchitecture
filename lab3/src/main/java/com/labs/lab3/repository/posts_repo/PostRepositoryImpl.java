package com.labs.lab3.repository.posts_repo;
import com.labs.lab3.entity.Post;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
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

    @Override
    public List<Post> findByTitle(String title) {
        return posts
                .stream()
                .filter(post -> post.getTitle().equalsIgnoreCase(title))
                .toList();
    }
    /*
        //if with JPA repo
        @Query("select p from Post p where p.title = :title")
        List<Post> findPostsByTitle(@Param("title") String title);
     */
}

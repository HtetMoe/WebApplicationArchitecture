package com.labs.lab4.service.impl;
import com.labs.lab4.entity.Comment;
import com.labs.lab4.entity.Post;
import com.labs.lab4.exception.ResourceNotFoundException;
import com.labs.lab4.repository.PostRepository;
import com.labs.lab4.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.lang.StringTemplate.STR;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(STR."Post not found with id \{id}"));
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void update(long id, Post post) {
       this.findById(id);
        postRepository.save(post);
    }

    //posts by author
    @Override
    public List<Post> filterPostsByAuthor(String author) {
        return postRepository.findByAuthor(author);
    }


    @Override
    public List<Post> searchPostsByAuthorNameContaining(String text) {
        return postRepository.findByAuthorContaining(text);
    }

    //5. Make it possible to add a comment that will be associated with its post.
    @Override
    public void addCommentToPost(long postId, Comment comment) {
        Post post = this.findById(postId);
        post.getComments().add(comment);
        postRepository.save(post);
    }

    @Override
    public List<Post> findPostsByTitle(String title) {
        return postRepository.findByTitle(title);
    }
}

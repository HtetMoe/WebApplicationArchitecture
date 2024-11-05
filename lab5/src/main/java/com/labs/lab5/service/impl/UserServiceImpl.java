package com.labs.lab5.service.impl;
import com.labs.lab5.entity.Comment;
import com.labs.lab5.entity.Post;
import com.labs.lab5.entity.User;
import com.labs.lab5.exception.ResourceNotFoundException;
import com.labs.lab5.logging.ExecutionTime;
import com.labs.lab5.repository.UserRepository;
import com.labs.lab5.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @ExecutionTime // => apply the ExecutionTime annotation
    @Override
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(STR."User with id \{id} not found"));
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Post> getPostsByUserId(long userId) {
        User user = this.findById(userId);
        return user.getPosts();
    }

    @Override
    public List<User> getUsersWithMoreThanNPosts(int postCount) {
        return userRepository.findUsersWithMoreThanNPosts(postCount);
    }

    @Override
    public List<User> findUsersByPostTitle(String title) {
        return userRepository.findUsersByPostTitle(title);
    }

    @Override
    public Comment findCommentByUserIdAndPostIdAndCommentId(long userId, long postId, long commentId) {
        User user = this.findById(userId);

        Post post = user.getPosts()
                .stream().filter(post1 -> post1.getId() == postId)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Post not found!"));

        return post.getComments()
                .stream().filter(comment -> comment.getId() == commentId)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Comment not found!"));
    }
}

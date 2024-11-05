package com.labs.lab4.service;
import com.labs.lab4.entity.Comment;
import com.labs.lab4.entity.Post;
import com.labs.lab4.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User findById(long id);

    void save(User user);

    void delete(long id);

    List<Post> getPostsByUserId(long userId);

    List<User> getUsersWithMoreThanNPosts(int postCount);

    List<User> findUsersByPostTitle(String title);

    Comment findCommentByUserIdAndPostIdAndCommentId(Long userId, Long postId, Long commentId);
}

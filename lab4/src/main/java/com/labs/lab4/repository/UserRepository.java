package com.labs.lab4.repository;

import com.labs.lab4.entity.Comment;
import com.labs.lab4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
// JPQL query - query language defined by JPA

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where SIZE(u.posts) > :postCount")
    List<User> findUsersWithMoreThanNPosts(@Param("postCount") int postCount);

    //Lab 3 => 9. Make a query that will find the users that made posts within a given title
    @Query("select u from User u join u.posts p where p.title = :title")
    List<User> findUsersByPostTitle(@Param("title") String title);

    @Query("select c from Post p join p.comments c join User u on u.id = :userId where p.id = :postId and c.id = :commentId")
    Optional<Comment> findCommentByUserIdAndPostIdAndCommentId(@Param("userId") Long userId,
                                                      @Param("postId") Long postId,
                                                      @Param("commentId") Long commentId);
}

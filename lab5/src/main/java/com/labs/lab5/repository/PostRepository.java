package com.labs.lab5.repository;
import com.labs.lab5.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAuthor(String author);

    List<Post> findByAuthorContaining(String text);

    List<Post> findByTitle(String title);

//    @Query("select p from Post p where p.author = :author")
//    List<Post> findByAuthorName(@Param("author") String author);
//
//    @Query("SELECT p FROM Post p WHERE p.title = :title")
//    List<Post> findByTitle(@Param("title") String title);
//
//    @Query("SELECT p FROM Post p WHERE p.author LIKE CONCAT('%', :author, '%')")
//    List<Post> findByAuthor(@Param("author") String author);
}

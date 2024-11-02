package com.labs.lab3.repository.comment_repo;

import com.labs.lab3.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
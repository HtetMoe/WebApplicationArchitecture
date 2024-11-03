package com.labs.lab4.repository.comment_repo;

import com.labs.lab4.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
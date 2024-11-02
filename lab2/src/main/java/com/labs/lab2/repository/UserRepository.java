package com.labs.lab2.repository;

import com.labs.lab2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // JPQL query - query language defined by JPA
    @Query("select u from User u where SIZE(u.posts) > :postCount")
    List<User> findByPostsSizeGreaterThan(@Param("postCount") int postCount);
}

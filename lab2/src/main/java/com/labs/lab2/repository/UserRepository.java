package com.labs.lab2.repository;

import com.labs.lab2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JPQL query - query language defined by JPA
    //List<User> findByPostsSizeGreaterThan(int postSize);
}

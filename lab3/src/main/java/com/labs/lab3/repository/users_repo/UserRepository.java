package com.labs.lab3.repository.users_repo;
import com.labs.lab3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
// JPQL query - query language defined by JPA

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where SIZE(u.posts) > :postCount")
    List<User> findUsersWithMoreThanPosts(@Param("postCount") int postCount);

    //Lab 3 : 9. Make a query that will find the users that made posts within a given title
    @Query("select distinct u from User u join u.posts p where p.title = :title")
    List<User> findUsersByPostTitle(@Param("title") String title);
}

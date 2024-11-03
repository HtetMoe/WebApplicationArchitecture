package com.labs.lab4.repository.aspect_repo;

import com.labs.lab4.entity.aspect.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Long> {
}

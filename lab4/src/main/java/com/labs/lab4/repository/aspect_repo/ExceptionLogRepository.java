package com.labs.lab4.repository.aspect_repo;

import com.labs.lab4.entity.aspect.ExceptionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionLogRepository extends JpaRepository<ExceptionLog, Long> {
}

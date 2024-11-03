package com.labs.lab4.repository.logger_repo;

import com.labs.lab4.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public interface LoggerRepository extends JpaRepository<Logger, Long> {
}

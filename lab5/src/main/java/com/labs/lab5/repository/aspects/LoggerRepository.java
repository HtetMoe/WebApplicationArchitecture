package com.labs.lab5.repository.aspects;
import com.labs.lab5.logging.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Long> {
}

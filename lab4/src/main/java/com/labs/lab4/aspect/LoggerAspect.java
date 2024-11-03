package com.labs.lab4.aspect;

import com.labs.lab4.entity.Logger;
import com.labs.lab4.repository.logger_repo.LoggerRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Aspect
@Component
public class LoggerAspect {
    @Autowired
    private LoggerRepository loggerRepository;

    private static final String PRINCIPLE = "fakeUser";  // Static fake user

    @Before("execution(* com.labs.lab4.service.*.*(..))") // belong to all methods inside it
    public void logOperation(JoinPoint joinPoint) {
        Logger log = new Logger();
        log.setDateTime(LocalDateTime.now());
        log.setPrinciple(PRINCIPLE);
        log.setOperation(joinPoint.getSignature().getName());
        System.out.println(STR."logger \{log}");
        loggerRepository.save(log);
    }

    @Around("@annotation(ExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        long end   = System.currentTimeMillis();
        Object result = joinPoint.proceed();

        System.out.println(STR."Execution time of \{joinPoint.getSignature()} is \{end - start} ms");
        return result;
    }
}

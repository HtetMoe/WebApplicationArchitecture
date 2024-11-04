package com.labs.lab4.logging;

import com.labs.lab4.exception.ExceptionLog;
import com.labs.lab4.repository.aspects.ExceptionLogRepository;
import com.labs.lab4.repository.aspects.LoggerRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Aspect
@Component
public class LogAspect {
    private final LoggerRepository loggerRepository;
    private final ExceptionLogRepository exceptionLogRepository;

    //measure execution time
    @Around("@annotation(ExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        long end   = System.currentTimeMillis();
        long execTime = start - end;
        Object result = joinPoint.proceed();

        System.out.println(STR."Execution time of \{joinPoint.getSignature()} is \{execTime} ms");
        return result;
    }

    //log the exceptions
    @AfterThrowing(pointcut = "execution(* com.labs.lab4.service..*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {

        //calculate execution time
        long start = System.currentTimeMillis();
        long execTime = System.currentTimeMillis() - start;

        ExceptionLog exceptionLog = new ExceptionLog();
        exceptionLog.setDateTime(LocalDateTime.now());
        exceptionLog.setExecutionTime(execTime);
        exceptionLog.setOperation(joinPoint.getSignature().getName());
        exceptionLog.setExceptionType(exception.getClass().getSimpleName());
        exceptionLogRepository.save(exceptionLog);

        System.out.println(STR."Log Exception for method: \{joinPoint.getSignature().getName()}");
    }

    //log all operations
    @Before("execution(* com.labs.lab4.service..*(..))") // belong to all methods inside it
    public void logOperation(JoinPoint joinPoint) {
        //calculate execution time
        long start = System.currentTimeMillis();
        long execTime = System.currentTimeMillis() - start;

        Logger logEntry = new Logger();
        logEntry.setDateTime(LocalDateTime.now());
        logEntry.setExecutionTime(execTime);
        logEntry.setOperation(STR."\{joinPoint.getSignature().getName()} executed in \{execTime}ms");
        loggerRepository.save(logEntry);

        System.out.println(STR."Logging operation for method: \{joinPoint.getSignature().getName()}");
    }
}

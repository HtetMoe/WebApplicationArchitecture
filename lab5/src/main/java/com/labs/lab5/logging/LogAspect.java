package com.labs.lab5.logging;

import com.labs.lab5.exception.ExceptionLog;
import com.labs.lab5.repository.aspects.ExceptionLogRepository;
import com.labs.lab5.repository.aspects.LoggerRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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

        long start    = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long execTime = System.currentTimeMillis() - start;

        System.out.println(STR."Execution time of \{joinPoint.getSignature()} is \{execTime} ms");
        return result;
    }

    //log the exceptions
    @Around(value = "execution(* com.labs.lab5.service..*(..))")
    public Object logException(ProceedingJoinPoint joinPoint) throws Throwable {

        //calculate execution time
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } catch (Throwable exception) {
            long execTime = System.currentTimeMillis() - start;

            ExceptionLog exceptionLog = new ExceptionLog();
            exceptionLog.setDateTime(LocalDateTime.now());
            exceptionLog.setExecutionTime(execTime);
            exceptionLog.setOperation(joinPoint.getSignature().getName());
            exceptionLog.setExceptionType(exception.getClass().getSimpleName());
            exceptionLogRepository.save(exceptionLog);

            System.out.println(STR."Exception in method: \{joinPoint.getSignature().getName()}");

            throw exception;
        }
    }

    //log all operations
    @Around("execution(* com.labs.lab5.service..*(..))") // belong to all methods inside it
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {

        //calculate execution time
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long execTime = System.currentTimeMillis() - start;

        Logger logEntry = new Logger();
        logEntry.setDateTime(LocalDateTime.now());
        logEntry.setExecutionTime(execTime);
        logEntry.setOperation(STR."\{joinPoint.getSignature().getName()} executed in \{execTime}ms");
        loggerRepository.save(logEntry);

        System.out.println(STR."Logging operation for method: \{joinPoint.getSignature().getName()}");

        return result;
    }
}

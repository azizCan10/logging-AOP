package com.test.loggingAOP.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class Logger {

    @Before("execution(* com.test.loggingAOP.service.*.*(..)) || execution(* com.test.loggingAOP.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        StringBuilder argsLog = new StringBuilder();

        for (Object arg : joinPoint.getArgs()) {
            argsLog.append(arg).append(", ");
        }

        if (!argsLog.isEmpty()) {
            log.info("{}.{}({}) method started.", className, methodName, argsLog.substring(0, argsLog.length() - 2));
        } else {
            log.info("{}.{}() method started.", className, methodName);
        }
    }

    @After("execution(* com.test.loggingAOP.service.*.*(..)) || execution(* com.test.loggingAOP.controller.*.*(..))")
    public void after(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        log.info("{}.{}() method ended.", className, methodName);
    }

    @AfterThrowing(pointcut = "execution(* com.test.loggingAOP.service.*.*(..))", throwing = "exception")
    public void logException(Throwable exception) {
        log.error("ERROR: {} WAS THROWN AT {}. ERROR MESSAGE: {}", exception.getClass().getSimpleName(), exception.getStackTrace()[0].toString(), exception.getMessage());
    }
}

package edu.miu.lab04.aspect;

import edu.miu.lab04.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    private LoggerService loggerService;

    @Autowired
    public LoggerAspect(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @Pointcut("execution(* edu.miu.lab04.controller.*.*(..))")
    public void logOperation() {}

    @Before("logOperation()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        loggerService.log("test", methodName);
    }
}

package edu.miu.lab04.aspect;

import edu.miu.lab04.service.ExceptionService;
import edu.miu.lab04.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {

    private final ExceptionService exceptionService;

    @Autowired
    public ExceptionAspect(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    @Pointcut("execution(* edu.miu.lab04.controller.*.*(..))")
    public void logException() {}

    @AfterThrowing(value = "logException()", throwing = "throwable")
    public void logException(JoinPoint joinPoint, Throwable throwable) {
        String methodName = joinPoint.getSignature().getName();
        exceptionService.log(methodName, throwable.getClass().getName());
    }
}

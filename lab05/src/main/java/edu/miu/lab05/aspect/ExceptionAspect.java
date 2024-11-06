package edu.miu.lab05.aspect;

import edu.miu.lab05.service.ExceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ExceptionAspect {

    private final ExceptionService exceptionService;

    @Autowired
    public ExceptionAspect(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    @Pointcut("execution(* edu.miu.lab05.controller.*.*(..))")
    public void logException() {}

    @AfterThrowing(value = "logException()", throwing = "throwable")
    public void logException(JoinPoint joinPoint, Throwable throwable) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        exceptionService.log(methodName, throwable.getClass().getName());
        System.out.println(Arrays.toString(throwable.getStackTrace()));
        throw throwable;
    }
}

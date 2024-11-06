package edu.miu.lab05.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Pointcut("@annotation(edu.miu.lab05.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {}

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();

        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            System.out.println("Operation: " + joinPoint.getSignature().getName() + ", Execution time: " + executionTime + " ns");
        }
    }
}

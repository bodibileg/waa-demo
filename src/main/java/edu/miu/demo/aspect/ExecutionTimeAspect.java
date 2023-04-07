package edu.miu.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Pointcut("@annotation(edu.miu.demo.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){}

    @Around("executionTimeAnnotation()")
    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        var result = proceedingJoinPoint.proceed();
        long finish = System.currentTimeMillis();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes " + (finish - start) + " ms");
        return result;
    }
}

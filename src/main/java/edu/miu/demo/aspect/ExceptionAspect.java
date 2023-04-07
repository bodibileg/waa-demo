package edu.miu.demo.aspect;

import edu.miu.demo.domain.Exception;
import edu.miu.demo.repo.ExceptionRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Aspect
@Component
public class ExceptionAspect {

    @Autowired
    ExceptionRepo exceptionRepo;

    @Pointcut("within(edu.miu.demo.controller..*)")
    public void exception(){};

    @Around("exception()")
    public Object saveException(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable ex) {
            Exception exception = new Exception();
            exception.setOperation(proceedingJoinPoint.getSignature().getName());
            exception.setPrinciple("user1");
            exception.setException_type(ex.getClass().getSimpleName());
            exception.setMessage(ex.getMessage());
            exceptionRepo.save(exception);
        }
        return null;
    }
}

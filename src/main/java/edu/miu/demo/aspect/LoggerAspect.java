package edu.miu.demo.aspect;

import edu.miu.demo.domain.Logger;
import edu.miu.demo.repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    LoggerRepo loggerRepo;

    @Pointcut("within(edu.miu.demo.controller..*)")
    public void log(){
    }

    @Before("log()")
    public void saveLog(JoinPoint joinPoint) {
        Logger log = new Logger();

        log.setPrinciple("user1");
        log.setOperation(joinPoint.getSignature().getName());

        loggerRepo.save(log);
    }

}

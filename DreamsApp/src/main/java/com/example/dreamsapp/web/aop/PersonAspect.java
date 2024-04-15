package com.example.dreamsapp.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class PersonAspect {
    @After("execution(* com.example.dreamsapp.web.controllers.PersonController.findAll(*))")
    public void afterUsersFinding(){
        log.info("++++++ PersonController.findAll() - After  ++++++");
    }

    @Before("execution(* com.example.dreamsapp.web.controllers.PersonController.findPerson(*))")
    public void beforeUserFinding(){
        log.info(":::::: PersonController.findPerson() - Before  ::::::");
    }

    @AfterReturning(pointcut = "execution(* com.example.dreamsapp.web.controllers.PersonController.createPerson(*))", returning = "result")
    public void afterUserCreation(Object result) {
        log.info("###### log - PersonController.createPerson() - After Returning = " + result.toString() + " ######");
    }
}

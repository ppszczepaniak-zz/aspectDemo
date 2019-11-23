package com.example.aspectDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.example.aspectDemo.service.NameCounter.countLetters(..))")         //point-cut expression
    public void countLettersAdvice(JoinPoint joinPoint)
    {
        System.out.println("===> AOP MESSAGE BEFORE NameCounter method with name: " + joinPoint.getSignature().getName());
    }


    @Before("execution(* com.example.aspectDemo.*.*(..))")
    public void anything(){
        System.out.println("===> AOP MESSAGE: BEFORE anything...");
    }

    @Before("execution(* com.example.aspectDemo.*.*.*(..))")
    public void anythingFromPackage(){
        System.out.println("===> AOP MESSAGE: BEFORE anything from any package...");
    }

    @Before("execution(public String getName())")
    public void getNameAdvice(){
        System.out.println("===> AOP MESSAGE: Executing Advice on getName()");
    }

    @Before("execution(* com.example.aspectDemo.model.*.get*())")
    public void getAllAdvice(){
        System.out.println("===> AOP MESSAGE: Model method getter called");
    }


    @After("execution(* com.example.aspectDemo.service.*.*(..))")
    public void afterMethod(){
        System.out.println("===> AOP MESSAGE: AFTER ANY service method comment");
    }

//    @AfterReturning(value = "execution(* com.example.aspectDemo.controller.*(..))", returning = "returnValue")
//    public void afterReturn(Object returnValue) throws Throwable {
//        System.out.println("value return was " + returnValue);
//    }

}

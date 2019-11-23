package com.example.aspectDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {



    @Before("execution(* com.example.aspectDemo.service.NameCounter.countLetters(..))")         //point-cut expression
    public void logBeforeV1(JoinPoint joinPoint)
    {
        System.out.println("===> AOP MESSAGE: NameCounter.countLetters() : " + joinPoint.getSignature().getName());
    }


    @Before("execution(* com.example.aspectDemo.*.*(..))")
    public void anything(){
        System.out.println("===> AOP MESSAGE: anything");
    }

    @Before("execution(public String getName())")
    public void getNameAdvice(){
        System.out.println("===> AOP MESSAGE: Executing Advice on getName()");
    }

    @Before("execution(* com.example.aspectDemo.*.get*())")
    public void getAllAdvice(){
        System.out.println("===> AOP MESSAGE: Service method getter called");
    }



//    @After("execution(* com.example.aspectDemo.*(..))")
//    public void afterMethod(){
//        System.out.println("===> this is after method comment");
//    }

//    @AfterReturning(value = "execution(* com.example.aspectDemo.controller.*(..))", returning = "returnValue")
//    public void afterReturn(Object returnValue) throws Throwable {
//        System.out.println("value return was " + returnValue);
//    }

}

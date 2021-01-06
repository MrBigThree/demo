package com.example.springbootdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/3
 */
@Component
@Aspect
public class Aop {


    @Around("execution(* com.example.springbootdemo.service.impl.*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "   do something before");
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println(name + "   do something after");
        return result;
    }
}

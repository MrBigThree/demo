package com.example.springbootdemo.aop;

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


    @Before("execution(* com.example.springbootdemo.service.impl.*.*(..))")
    public void doAround() {
        System.out.println("do something before");
    }
}

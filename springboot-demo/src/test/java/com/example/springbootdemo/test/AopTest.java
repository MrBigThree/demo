package com.example.springbootdemo.test;

import com.example.springbootdemo.service.Service2;
import com.example.springbootdemo.service.impl.Service2Impl;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/3
 */
@SpringBootTest
public class AopTest {

    @Autowired
    private Service2 service2;


    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Method method = service2.getClass().getMethod("selfDoSomething1");
//        method.invoke(service2);
        service2.doSomething();
    }
}

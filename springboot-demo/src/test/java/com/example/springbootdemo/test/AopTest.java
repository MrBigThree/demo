package com.example.springbootdemo.test;

import com.example.springbootdemo.service.Service2;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void test() {
        service2.doSomething();
    }
}

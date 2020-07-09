package com.example.springbootdemo.test;

import org.junit.jupiter.api.Test;
import org.springboot.starter.demo.DemoService;
import org.springboot.starter.demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/8
 */
@SpringBootTest(properties = "demo-starter.enabled=true")
public class AutoConfigTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DemoService demoService;

    @Test
    public void test() {
        userService.helloWorld();
        demoService.demo();
    }
}

package com.example.springbootdemo;

import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/19
 */

@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }


    public void index(Test test) {

    }

    public static void main(String[] args) throws Exception {
        Method method = TestController.class.getMethod("index", Test.class);
        DefaultParameterNameDiscoverer defaultParameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        String[] parameterNames = defaultParameterNameDiscoverer.getParameterNames(method);

    }

}
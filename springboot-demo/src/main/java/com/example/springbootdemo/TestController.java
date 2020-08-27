package com.example.springbootdemo;

import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/19
 */

@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        System.out.println(classLoader);
        return "hello";
    }


    public void index(HashMap<String, String> test) {

    }

    public static void main(String[] args) throws Exception {
        Method method = TestController.class.getMethod("index", HashMap.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (int i = 0; i < genericParameterTypes.length; i++) {
            ParameterizedTypeImpl t = (ParameterizedTypeImpl) genericParameterTypes[i];
            Type[] actualTypeArguments = t.getActualTypeArguments();
            for (int j = 0; j < actualTypeArguments.length; j++) {
                Type type = actualTypeArguments[j];

                System.out.println(type.getClass());
            }

        }

    }

}
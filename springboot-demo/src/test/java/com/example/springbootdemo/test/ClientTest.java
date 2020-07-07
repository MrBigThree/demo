package com.example.springbootdemo.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/4
 */
public class ClientTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Son son = new Son();
        Field[] fields = son.getClass().getDeclaredFields();
        Constructor<? extends Son> constructor = son.getClass().getConstructor();
        constructor.isAccessible()
        Son son1 = constructor.newInstance();
        Method doSomething = son.getClass().getSuperclass().getDeclaredMethod("doSomething");
        doSomething.setAccessible(true);
        boolean accessible = doSomething.isAccessible();
        doSomething.invoke(son);
        System.out.println(accessible);
        for (Field field : fields) {
            boolean accessible1 = field.isAccessible();
            System.out.println(field.getName());
        }
        Method[] methods = Son.class.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            System.out.println(name);
        }
    }
}

package com.example.springbootdemo;

import java.util.List;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/28
 */
public class Test {

    public static void main(String[] args) {
        String[] strings = new String[10];
        Class<? extends String[]> aClass = strings.getClass();
        System.out.println(aClass);
    }
}

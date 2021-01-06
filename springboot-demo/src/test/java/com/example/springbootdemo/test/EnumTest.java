package com.example.springbootdemo.test;

import com.example.springbootdemo.TEnum;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/12/31
 */
public class EnumTest {

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InstantiationException {

        Constructor<?>[] constructors = TEnum.class.getDeclaredConstructors();

        TEnum tEnum = TEnum.class.newInstance();

    }
}

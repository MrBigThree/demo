package com.example.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/7
 */
public class SampleClass {

    public void doSomething() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(
                (MethodInterceptor) (obj, method, args1, proxy) -> {

                    Object o = proxy.invokeSuper(obj, args1);

                    return o;
                }

        );
        SampleClass sample = (SampleClass) enhancer.create();
        sample.doSomething();
    }
}

package com.example.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/7
 */
public class SampleClass {

    public String doSomething() {
        System.out.println("hello world");
        return "hello world";
    }


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(
                (MethodInterceptor) (obj, method, args1, proxy) -> {
                    Object o = proxy.invokeSuper(obj, args1);
                    if(o instanceof String){

                    }

                    if ("hello world".equals(o)) {
                        return "hello world proxy";
                    }
                    return o;
                }
        );
        SampleClass sample = (SampleClass) enhancer.create();
        String s = sample.doSomething();
        System.out.println(s);
    }
}

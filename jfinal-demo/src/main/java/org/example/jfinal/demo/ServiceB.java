package org.example.jfinal.demo;

import com.jfinal.aop.Aop;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/19
 */
public class ServiceB {

    public static final ServiceB me = new ServiceB();

    public ServiceB() {
        System.out.println("ServiceB constructor");
    }

    ServiceA aService;

    public void doSomething() {
        aService = Aop.get(ServiceA.class);
        aService.test();
    }
}

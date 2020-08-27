package org.example.jfinal.demo;

import com.jfinal.aop.Inject;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/19
 */
public class ServiceA {

    @Inject
    ServiceC serviceC;

    public void test() {
        System.out.println("test");
        serviceC.test();
    }


}

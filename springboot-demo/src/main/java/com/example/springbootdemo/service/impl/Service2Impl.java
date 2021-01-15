package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.service.Service2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/19
 */
@Service
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Service2Impl implements Service2, InitializingBean {

    @Autowired
    private Service2Impl service2;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void doSomething() {
      //  System.out.println(service2.getClass().getName());
        service2.selfDoSomething();
        service2.selfDoSomething1();
    }
    @Override
    public void selfDoSomething() {
        //System.out.println(service2.getClass().getName());
        System.out.println("selfDoSomething");
    }
    @Override
    public void selfDoSomething1() {
        System.out.println(service2.getClass().getName());
        System.out.println("selfDoSomething1");
    }



}

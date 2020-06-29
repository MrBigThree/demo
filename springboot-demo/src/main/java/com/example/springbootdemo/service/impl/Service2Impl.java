package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.service.Service2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/19
 */
@Service
public class Service2Impl implements Service2, InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}

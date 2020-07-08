package org.springboot.starter.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/8
 */
@Configuration
public class AutoConfiguration2 {

    @Bean
    public DemoService demoService() {
        return new DemoService();
    }
}

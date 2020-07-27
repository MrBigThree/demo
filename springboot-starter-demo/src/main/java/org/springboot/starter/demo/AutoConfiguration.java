package org.springboot.starter.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/8
 */
@Configuration
@ConditionalOnProperty(prefix = "demo-starter", name = "enabled", havingValue = "true")
public class AutoConfiguration {

    @Bean
    public UserService userService() {


        return new UserService();
    }
}

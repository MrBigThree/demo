package org.example.nacos.demo;

import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/1/13
 */
@SpringBootApplication
@EnableNacosConfig
public class NacosDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDemoApplication.class, args);
    }
}

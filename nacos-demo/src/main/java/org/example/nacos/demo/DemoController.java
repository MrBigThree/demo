package org.example.nacos.demo;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/1/13
 */
@RestController
public class DemoController {

    @Value("${name}")
    private String name;


    @NacosValue(value = "${name}", autoRefreshed = true)
    private String name1;

    @GetMapping("helloWorld")
    public String helloWorld() {
        return name;
    }

    @GetMapping("helloWorld1")
    public String helloWorld1() {
        return name1;
    }
}

package org.example.hystrix.demo;

import com.netflix.hystrix.*;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/9/8
 */
public class HelloWorldHystrixCommand extends HystrixCommand<String> {

    private final String name;

    protected HelloWorldHystrixCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("example group"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("example"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerRequestVolumeThreshold(10)//至少有10个请求，熔断器才进行错误率的计算
                        .withCircuitBreakerSleepWindowInMilliseconds(5000)//熔断器中断请求5秒后会进入半打开状态,放部分流量过去重试
                        .withCircuitBreakerErrorThresholdPercentage(50)//错误率达到50开启熔断保护
                        .withExecutionTimeoutEnabled(true))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties
                        .Setter().withCoreSize(10)));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "Hello  " + name;
    }

    @Override
    protected String getFallback() {
        return super.getFallback();
    }
}

package org.example.redission.demo;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/7
 */
public class RedisDemo {

    public static void main(String[] args) throws InterruptedException {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://20.21.1.118:6379");
        RedissonClient redisson = Redisson.create(config);
        RMap<Object, Object> map = redisson.getMap("test");
        map.put("name", "aaa");
        map.put("age", "123");
        RLock lock = redisson.getLock("test");

        lock.tryLock(500, 10000, TimeUnit.MILLISECONDS);

        lock.lock();
        System.out.println("test");
        lock.unlock();
        redisson.shutdown();
    }

}

package org.example.redission.demo;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/7
 */
public class RedisDemo {

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://20.21.1.118:6379");
        RedissonClient redisson = Redisson.create(config);
        RMap<Object, Object> map = redisson.getMap("test");
        map.put("name", "aaa");
        map.put("age", "123");
        RReadWriteLock readWriteLock = redisson.getReadWriteLock("test");
        readWriteLock.readLock().lock();
        redisson.shutdown();
    }

}

package org.example.redission.demo;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;

import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/7
 */
public class RedisDemo {

    public static void main(String[] args) throws InterruptedException {
//        Config config = new Config();
//        config.useSingleServer()
//                .setAddress("redis://20.21.1.118:6379");
//        RedissonClient redisson = Redisson.create(config);
//        RMap<Object, Object> map = redisson.getMap("test");
//        map.put("name", "aaa");
//        map.put("age", "123");
//        RLock lock = redisson.getLock("test");
//
//        lock.tryLock(500, 10000, TimeUnit.MILLISECONDS);
//
//        lock.lock();
//        System.out.println("test");
//        lock.unlock();
//        redisson.shutdown();
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://121.40.121.214:6379")
                .setPassword("pds2019");
        RedissonClient redisson = Redisson.create(config);
//
//        RLock lock = redisson.getLock("123");
//        lock.lock();

        RBloomFilter<Object> bloomFilter = redisson.getBloomFilter("123455");

        bloomFilter.tryInit(100000000L,0.03);
        bloomFilter.add("10002");
        bloomFilter.add("10003");

        boolean contains = bloomFilter.contains("10002");
        System.out.println(contains);
//        lock.unlock();
//        redisson.shutdown();
    }

}

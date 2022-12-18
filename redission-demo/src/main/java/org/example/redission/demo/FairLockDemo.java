package org.example.redission.demo;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/17
 */
public class FairLockDemo {

    public static void main(String[] args) throws Exception {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://121.40.121.214:6379")
                .setPassword("pds2019");
        RedissonClient redisson = Redisson.create(config);

        RLock lock = redisson.getLock("123");
        lock.lock();


        RBucket<Object> bucket = redisson.getBucket("");


    }
}

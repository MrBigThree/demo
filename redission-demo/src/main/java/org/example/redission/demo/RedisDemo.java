package org.example.redission.demo;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/7
 */
public class RedisDemo {

    public static void main(String[] args) throws Exception {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://20.21.1.118:6379");
        RedissonClient redisson = Redisson.create(config);
        RLock lock = redisson.getLock("anyLock");

        lock.lock();
        try {
            Thread.sleep(2000);
        } finally {
            System.out.println("123");
            lock.unlock();
        }
    }
}

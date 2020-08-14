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
        new Thread(() -> {
            Config config = new Config();
            config.useSingleServer()
                    .setAddress("redis://20.21.1.118:6379");
            RedissonClient redisson = Redisson.create(config);
            RLock lock = redisson.getLock("anyLock");
            System.out.println(Thread.currentThread().getId());
            lock.lock();
            try {
                Thread.sleep(200000);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                System.out.println("123");
                lock.unlock();
            }
        }).start();
        new Thread(new L()).start();
    }

    static class L implements Runnable {
        @Override
        public void run() {
            Config config = new Config();
            config.useSingleServer()
                    .setAddress("redis://20.21.1.118:6379");
            RedissonClient redisson = Redisson.create(config);
            RLock lock = redisson.getLock("anyLock");
            System.out.println(Thread.currentThread().getId());
            lock.lock();
            try {
                Thread.sleep(20000);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                System.out.println("123");
                lock.unlock();
            }
        }
    }
}

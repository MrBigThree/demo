package org.example.zookeeper.demo;

import java.util.concurrent.locks.Lock;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/12/10
 */
public class WatchDemo1 {


    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DistributedLock lock = new DistributedLock();
                lock.lock();
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                DistributedLock1 lock = new DistributedLock1();
                lock.lock();
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }


            }
        }).start();


    }

}

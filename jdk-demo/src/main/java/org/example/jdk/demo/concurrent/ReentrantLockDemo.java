package org.example.jdk.demo.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/29
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(() -> {
            reentrantLock.lock();
            try {
                Thread.sleep(1000 * 60 * 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();

        }).start();

        new Thread(() -> {
            reentrantLock.lock();

            reentrantLock.unlock();

        }).start();

    }
}

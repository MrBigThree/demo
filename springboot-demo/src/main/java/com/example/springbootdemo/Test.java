package com.example.springbootdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/28
 */
public class Test {

    private AtomicInteger j = new AtomicInteger();

    public void increment() {
        j.incrementAndGet();
    }

    public void decrement() {
        j.decrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        CountDownLatch downLatch = new CountDownLatch(2);
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                test.increment();
            }
            System.out.println(Thread.currentThread().getName() + " : " + test.j.get());
            downLatch.countDown();
        });
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                test.decrement();
            }
            System.out.println(Thread.currentThread().getName() + " : " + test.j.get());
            downLatch.countDown();
        });
        thread.start();
        thread1.start();
        downLatch.await();
        System.out.println(Thread.currentThread().getName() + " : " + test.j.get());

    }
}

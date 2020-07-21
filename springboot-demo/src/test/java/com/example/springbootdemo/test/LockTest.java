package com.example.springbootdemo.test;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/16
 */
public class LockTest {

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("do something");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("do something after");
            }
        }).start();


        new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("do something 1");
                lock.notify();
                System.out.println("do something after 1");
            }
        }).start();

    }
}

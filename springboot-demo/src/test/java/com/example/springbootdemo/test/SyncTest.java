package com.example.springbootdemo.test;


/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/16
 */
public class SyncTest {

    public synchronized void test1() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("test1");
    }

    public synchronized void test2() {
        System.out.println("test2");
    }

    public void test3() {
        System.out.println("1231231");
    }



    public static void main(String[] args) {
        final SyncTest test = new SyncTest();
        new Thread(() -> {
            try {
                test.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> test.test2()).start();

        new Thread(() -> test.test3()).start();
    }
}

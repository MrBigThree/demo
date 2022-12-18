package org.example.jdk.demo.concurrent;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2022/2/28
 */
public class SyncDemo {

//    Object object = new Object();

//    public void m1() {
//        synchronized (object) {
//            System.out.println("hello sync");
//        }
//    }


    public static synchronized void m1() {
        System.out.println("hello sync");
    }
//
//    public static void main(String[] args) {
//
//    }

}

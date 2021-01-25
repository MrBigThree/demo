package com.example.webfluxdemo;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/1/21
 */
public class NoVisibility {


    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start(); //启动一个线程
        number = 42;
        ready = true;
    }
}

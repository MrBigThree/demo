package org.example.jdk.demo.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/11
 */
public class IOTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        for (int i = 0; i < 10000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        }

    }
}

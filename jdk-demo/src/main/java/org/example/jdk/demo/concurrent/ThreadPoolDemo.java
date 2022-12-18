package org.example.jdk.demo.concurrent;

import java.math.BigDecimal;
import java.util.concurrent.*;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2022/2/24
 */
public class ThreadPoolDemo {

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
//
////        Future<Object> future = threadPool.submit(new Runnable() {
////            @Override
////            public void run() {
////                System.out.println(1 / 0);
////            }
////        }, new Object());
////        try {
////            Object o = future.get();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//
//
//        threadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(1 / 0);
//            }
//        });
//
//    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService execute = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        execute.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("=====11=======");
            }
        });

        TimeUnit.SECONDS.sleep(5);
        execute.execute(new Run1());
    }


    private static class Run1 implements Runnable {
        @Override
        public void run() {
            int count = 0;
            while (true) {
                count++;
                System.out.println("-------222-------------{}" + count);

                if (count == 10) {
                    try {
                        System.out.println(1 / 0);
                    } catch (Exception e) {
                        System.out.println("Exception");
                    }
                }

                if (count == 20) {
                    System.out.println("count={}" + count);
                   // break;
                }
            }
        }
    }
}

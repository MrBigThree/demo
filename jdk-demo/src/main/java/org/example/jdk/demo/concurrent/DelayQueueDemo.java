package org.example.jdk.demo.concurrent;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/18
 */
public class DelayQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue queue = new DelayQueue<>();

        new Thread(new Runnable() {
            @Override
            public void run() {

                queue.offer(new DelayTask("task1", 10000));
                queue.offer(new DelayTask("task2", 3900));
//                try {
//                    Thread.sleep(5000);
//                    System.out.println("休眠五秒");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                queue.offer(new DelayTask("task3", 1900));
                queue.offer(new DelayTask("task4", 5900));
                queue.offer(new DelayTask("task5", 100));
                queue.offer(new DelayTask("task6", 7900));
                queue.offer(new DelayTask("task7", 4900));

            }
        }).start();
        System.out.println("开始获取");
        while (true) {
            Delayed take = queue.take();
            System.out.println(take);
        }


    }

    static class DelayTask implements Delayed {

        private String name;

        private long start = System.currentTimeMillis();

        private long delayTime;

        public DelayTask(String name, long delayTime) {
            this.name = name;
            this.delayTime = delayTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert((start + delayTime) - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return "DelayTask{" +
                    "name='" + name + '\'' +
                    ", start=" + start +
                    ", time=" + delayTime +
                    '}';
        }
    }
}

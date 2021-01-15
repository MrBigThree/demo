package org.example.nacos.demo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/1/8
 */
public class NacosConfigExample {

    //server-addr: 20.21.1.135:8848
    //namespace: 16772d1e-f4fe-4414-b2e1-53730e74573e
    public static void main(String[] args) throws NacosException, InterruptedException {
//        String serverAddr = "20.21.1.135:8848";
//        String dataId = "application-default.yml";
//        String group = "DEFAULT_GROUP";
//        Properties properties = new Properties();
//        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
//        properties.put(PropertyKeyConst.NAMESPACE, "16772d1e-f4fe-4414-b2e1-53730e74573e");
//        ConfigService configService = NacosFactory.createConfigService(properties);
//        String content = configService.getConfig(dataId, group, 5000);
//        System.out.println(content);
//        configService.addListener(dataId, group, new Listener() {
//            @Override
//            public void receiveConfigInfo(String configInfo) {
//                System.out.println("recieve:" + configInfo);
//            }
//
//            @Override
//            public Executor getExecutor() {
//                return null;
//            }
//        });
//
//        boolean isPublishOk = configService.publishConfig(dataId, group, "content");
//        System.out.println(isPublishOk);
//
//        Thread.sleep(3000);
//        content = configService.getConfig(dataId, group, 5000);
//        System.out.println(content);
//
//        boolean isRemoveOk = configService.removeConfig(dataId, group);
//        System.out.println(isRemoveOk);
//        Thread.sleep(3000);
//
//        content = configService.getConfig(dataId, group, 5000);
//        System.out.println(content);
//        Thread.sleep(300000);

//        Map<Integer, String> hashMap = new ConcurrentHashMap<>();
//
//        hashMap.put(1, "123");
//        hashMap.put(17, "123");
//        hashMap.put(17 + 16, "123");
//        hashMap.put(17 + 16 + 16, "123");
//        hashMap.put(17 + 16 + 16 + 16, "123");
//        hashMap.put(17 + 16 + 16 + 16 + 16, "123");
//        hashMap.put(17 + 16 + 16 + 16 + 16 + 16, "123");
//        hashMap.put(17 + 16 + 16 + 16 + 16 + 16 + 16, "123");
//        hashMap.put(17 + 16 + 16 + 16 + 16 + 16 + 16 + 16, "123");
//        ArrayList list = new ArrayList<String>();
//
//
//        Iterator iterator = hashMap.keySet().iterator();
//        while (iterator.hasNext()) {
//            Object next = iterator.next();
//            System.out.println(next);
//        }


        BlockingQueue workQueue = new LinkedBlockingQueue<>(1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.MINUTES, workQueue, ((r, executor) -> {
            Class<? extends Runnable> aClass = r.getClass();
            FutureTask futureTask = (FutureTask) r;
            System.out.println(futureTask.getClass());
        }));
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("task1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("task2");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("task3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable task4 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("task4");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        threadPoolExecutor.submit(task1);
        threadPoolExecutor.submit(task2);
        threadPoolExecutor.submit(task3);
        threadPoolExecutor.submit(task4);


        threadPoolExecutor.shutdown();
        System.out.println("shutdown");

        ReentrantLock lock = new ReentrantLock();

        Semaphore semaphore = new Semaphore(1);
    }
}

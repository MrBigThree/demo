package org.example.zookeeper.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author leeSmall
 * @Description: 在业务里面使用分布式锁
 * @date 2018年9月4日
 */
public class OrderServiceImpl implements Runnable {

    private static OrderCodeGenerator ong = new OrderCodeGenerator();

    // 同时并发的线程数
    private static final int NUM = 10;
    // 按照线程数初始化倒计数器,倒计数器
    private static CountDownLatch cdl = new CountDownLatch(NUM);

    private Lock lock = new DistributedLock();

    // 创建订单接口
    public void createOrder() {
        String orderCode = null;

        //准备获取锁
        lock.lock();
        try {
            // 获取订单编号
            orderCode = ong.getOrderCode();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            //完成业务逻辑以后释放锁
            lock.unlock();
        }

        // ……业务代码
        System.out.println("insert into DB使用id：=======================>" + orderCode);
    }


    public void run() {
        try {
            // 等待其他线程初始化
            cdl.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 创建订单
        createOrder();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= NUM; i++) {
            // 按照线程数迭代实例化线程
            new Thread(new OrderServiceImpl()).start();
            // 创建一个线程，倒计数器减1
            cdl.countDown();
        }
    }
}

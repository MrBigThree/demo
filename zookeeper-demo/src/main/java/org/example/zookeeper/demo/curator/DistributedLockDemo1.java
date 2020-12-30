package org.example.zookeeper.demo.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/12/10
 */
public class DistributedLockDemo1 {

    // ZooKeeper 锁节点路径, 分布式锁的相关操作都是在这个节点上进行
    private final String lockPath = "/distributed-lock";

    // ZooKeeper 服务地址, 单机格式为:(127.0.0.1:2181), 集群格式为:(127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183)
    private static String connectString = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
    // Curator 客户端重试策略
    private RetryPolicy retry;
    // Curator 客户端对象
    private CuratorFramework client;
    // client2 用户模拟其他客户端
    private CuratorFramework client2;


    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

        CuratorFramework client = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
        client.start();

        client.getData().usingWatcher(new CuratorWatcher() {
            @Override
            public void process(WatchedEvent event) throws Exception {
                System.out.println(event);
            }
        }).forPath("/ourPath");


//        //创建分布式锁, 锁空间的根节点路径为/curator/lock
//        InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");
//
//
//        mutex.acquire();
//        System.out.println(System.currentTimeMillis() + "Enter mutex");
//        Thread.sleep(100000);
//        System.out.println(System.currentTimeMillis() + "Enter release");
//        //完成业务流程, 释放锁
//        mutex.release();
//        //关闭客户端
        client.close();
    }
}

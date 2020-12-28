package org.example.zookeeper.demo;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

import java.util.concurrent.locks.Lock;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/12/10
 */
public class WatchDemo {


    private static final String ZOOKEEPER_IP_PORT = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";


    public static void main(String[] args) throws InterruptedException {
        DistributedLock lock = new DistributedLock();
        lock.lock();
        try {
            Thread.sleep(3000);
        }finally {
            lock.unlock();
        }
    }
}

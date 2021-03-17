package org.example.zookeeper.demo;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/12/9
 */
public class DistributedLock implements Lock {


    private static final String ZOOKEEPER_IP_PORT = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
    private static final String LOCK_PATH = "/LOCK";

    private ZkClient client = new ZkClient(ZOOKEEPER_IP_PORT, 4000, 4000, new SerializableSerializer());

    private CountDownLatch cdl;

    private String beforePath;// 当前请求的节点前一个节点
    private String currentPath;// 当前请求的节点

    // 判断有没有LOCK目录，没有则创建
    public DistributedLock() {
        if (!this.client.exists(LOCK_PATH)) {
            this.client.createPersistent(LOCK_PATH);
        }
    }

    @Override
    public void lock() {
        //尝试去获取分布式锁失败
        if (!tryLock()) {
            //对次小节点进行监听
            waitForLock();
            lock();
        } else {
            System.out.println(Thread.currentThread().getName() + " 获得分布式锁！");
        }
    }

    //等待锁,对次小节点进行监听
    private void waitForLock() {
        IZkDataListener listener = new IZkDataListener() {
            public void handleDataDeleted(String dataPath) throws Exception {
                synchronized (DistributedLock.class) {
                    System.out.println(Thread.currentThread().getName() + dataPath + ":捕获到DataDelete事件！---------------------------");
                    DistributedLock.class.notifyAll();
                }
            }

            public void handleDataChange(String dataPath, Object data) throws Exception {

            }
        };

        // 对次小节点进行监听,即beforePath-给排在前面的的节点增加数据删除的watcher
        synchronized (DistributedLock.class) {
            this.client.subscribeDataChanges(beforePath, listener);
            if (this.client.exists(beforePath)) {
                //如果此时beforePath 的锁被释放，这个锁将会永远无法获取，卡死
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "存在");
                cdl = new CountDownLatch(1);
                try {
                    DistributedLock.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        this.client.unsubscribeDataChanges(beforePath, listener);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        // 如果currentPath为空则为第一次尝试加锁，第一次加锁赋值currentPath
        if (currentPath == null || currentPath.length() <= 0) {
            // 创建一个临时顺序节点
            currentPath = this.client.createEphemeralSequential(LOCK_PATH + '/', "lock");
            System.out.println("---------------------------->" + currentPath);
        }

        // 获取所有临时节点并排序，临时节点名称为自增长的字符串如：0000000400
        List<String> childrens = this.client.getChildren(LOCK_PATH);
        //由小到大排序所有子节点
        Collections.sort(childrens);
        //判断创建的子节点/LOCK/Node-n是否最小,即currentPath,如果当前节点等于childrens中的最小的一个就占用锁
        if (currentPath.equals(LOCK_PATH + '/' + childrens.get(0))) {
            return true;
        }
        //找出比创建的临时顺序节子节点/LOCK/Node-n次小的节点,并赋值给beforePath
        else {
            int wz = Collections.binarySearch(childrens, currentPath.substring(6));
            beforePath = LOCK_PATH + '/' + childrens.get(wz - 1);
        }

        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        // 删除当前临时节点
        client.delete(currentPath);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

package org.example.redission.demo.sentinel;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;
import org.redisson.config.ReadMode;
import org.redisson.config.SentinelServersConfig;
import org.redisson.connection.balancer.RoundRobinLoadBalancer;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/12/22
 */
public class SentinelDemo {
    //测试自动切换
    public static void main(String[] args) {
        Config config = new Config();
        config.useSentinelServers()
                .setMasterName("mymaster")
                .addSentinelAddress("redis://127.0.0.1:26379", "redis://127.0.0.1:26380", "redis://127.0.0.1:26381")
                .setPassword("password")
                .setReadMode(ReadMode.SLAVE)
                .setLoadBalancer(new RoundRobinLoadBalancer());
        RedissonClient redissonClient = Redisson.create(config);
        RMap<Object, Object> map = redissonClient.getMap("");
        RBucket<Object> test = redissonClient.getBucket("test");
        test.set("test");
        RBloomFilter<Object> bloomFilter = redissonClient.getBloomFilter("");
        bloomFilter.contains("");
        System.out.println("test result is : " + test.get());
        RBitSet bitSet = redissonClient.getBitSet("");
        bitSet.set(10L,true);
        //当只有读请求的时候 （read only），可以使用负载均衡把请求发送到各个slave上面
        //当既有读请求又有写请求时，应该把读请求也发送到 master ，防止出现不一致的情况。
    }
}

package org.example.rocketmq.demo;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/16
 */
public class Consumer {

    public static void main(String[] args) throws InterruptedException, MQClientException {

        // 实例化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_test_group");

        // 设置NameServer的地址
        consumer.setNamesrvAddr("20.21.1.118:9876");

        // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
        consumer.subscribe("canal_visitor", "*");

        // 注册回调实现类来处理从broker拉取回来的消息
        consumer.registerMessageListener(new MessageListenerOrderly() {

            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {

                msgs.forEach(messageExt -> {
                    byte[] body = messageExt.getBody();
                    String s = new String(body);
                    System.out.println("接收到消息" + s);
                });
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });


        // 启动消费者实例
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}

package charpter3.netty;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 消息体
 * @author:lvxuhong
 * @date:2020/5/25
 */
@Data
public class NettyMessage {

    private Header header;

    private Object body;

    @Data
    public static class Header {

        /**
         * 消息校验值 ，
         * 0xABEF 证明是netty消息
         * 0xABEF-主版本号-次版本号
         */
        private int crcCode = 0xABEF0101;

        /**
         * 消息长度
         */
        private int length;

        /**
         * 会话id
         */
        private long sessionId;

        /**
         * 消息类型
         * 0 业务请求消息
         * 1 业务响应消息
         * 2 业务ONE WAY 消息，既是请求又是响应
         * 3 握手请求消息
         * 4 握手应答消息
         * 5 心跳请求消息
         * 6 心跳应答消息
         */
        private byte type;

        private byte priority;

        private Map<String, Object> attachment = new HashMap<>();

    }
}

package charpter3.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingEncoder;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description: 消息编码器
 * @author:lvxuhong
 * @date:2020/5/25
 */
public class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage> {

    MarshallingEncoder marshallingEncoder;


    @Override
    protected void encode(ChannelHandlerContext ctx, NettyMessage msg, List<Object> out) throws Exception {
        if (msg == null || msg.getHeader() == null) {
            throw new Exception("message or message header header is null");
        }
        ByteBuf byteBuf = Unpooled.buffer();

        NettyMessage.Header header = msg.getHeader();
        Map<String, Object> attachment = header.getAttachment();

        byteBuf.writeInt(header.getCrcCode());
        byteBuf.writeInt(header.getLength());
        byteBuf.writeLong(header.getSessionId());
        byteBuf.writeByte(header.getType());
        byteBuf.writeByte(header.getPriority());
        byteBuf.writeInt(attachment.size());
        attachment.entrySet().stream().forEach(entry -> {
            String key = entry.getKey();
            Object value = entry.getValue();
            byte[] keyBytes = key.getBytes();
            byteBuf.writeInt(keyBytes.length);
            byteBuf.writeBytes(keyBytes);
        });


    }
}

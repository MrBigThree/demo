package handlerchain;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/13
 */
public class Decoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        ByteBuf byteBuf = in.readBytes(1);
        byte aByte = byteBuf.getByte(0);
        if (aByte == 1) {
            out.add(new User("tom", 10));
        }
        if (aByte == 0) {
            out.add(new Info("1213", "info"));
        }


    }
}

package charpter2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/5/18
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf byteBuf;

    public TimeClientHandler() {
        byte[] bytes = "QUERY TIME ORDER".getBytes();
        this.byteBuf = Unpooled.buffer(bytes.length);
        byteBuf.writeBytes(bytes);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 100; i++) {
            byte[] bytes = "你好，我的名字是斤斤计较斤斤计较斤斤计较".getBytes();
            this.byteBuf = Unpooled.buffer(bytes.length);
            byteBuf.writeBytes(bytes);
            ctx.writeAndFlush(this.byteBuf);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf resByteBuf = (ByteBuf) msg;
        byte[] res = new byte[resByteBuf.readableBytes()];
        resByteBuf.readBytes(res);
        String s = new String(res, StandardCharsets.UTF_8);
        System.out.println("now is " + s);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}

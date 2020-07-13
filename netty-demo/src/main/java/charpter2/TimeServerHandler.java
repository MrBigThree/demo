package charpter2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/5/18
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byteBuf.readableBytes();
        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(req);
        System.out.println(">>>>>>>>" + new String(req, "UTF-8"));
        // String currentTime = TimeServerUtil.getCurrentTime(req);
        ByteBuf resBuf = Unpooled.copiedBuffer(getRes());
        ctx.write(resBuf);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelReadComplete");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exceptionCaught");
        ctx.close();
    }

    private byte[] getRes() {
        String str = "HTTP/1.1 200 OK\n" +
                "Date: Sat, 31 Dec 2005 23:59:59 GMT\n" +
                "Content-Type: text/html;charset=UTF-8\n" +
                "Content-Length: 149\n" +
                "\n";
        str = str + "<!DOCTYPE html>＜html＞\n" +
                "＜head＞\n" +
                "＜title＞Wrox Homepage＜/title＞\n" +
                "＜/head＞\n" +
                "＜body＞\n" +
                "＜!-- body goes here --＞\n" +
                "＜/body＞\n" +
                "＜/html＞    ";

        return str.getBytes(Charset.forName("UTF-8"));

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "<!DOCTYPE html>＜html＞\n" +
                "＜head＞\n" +
                "＜title＞Wrox Homepage＜/title＞\n" +
                "＜/head＞\n" +
                "＜body＞\n" +
                "＜!-- body goes here --＞\n" +
                "＜/body＞\n" +
                "＜/html＞";

         System.out.println(str.getBytes("UTF-8").length);
    }
}

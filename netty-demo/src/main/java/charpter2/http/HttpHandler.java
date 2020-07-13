package charpter2.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/5/18
 */
public class HttpHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if(msg instanceof HttpRequest){
            ByteBuf content = Unpooled.copiedBuffer("hello world".getBytes());
            DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            defaultFullHttpResponse.headers().add(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            defaultFullHttpResponse.headers().add(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            ctx.writeAndFlush(defaultFullHttpResponse);
        }
    }
}

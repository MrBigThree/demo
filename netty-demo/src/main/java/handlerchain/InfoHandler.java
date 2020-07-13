package handlerchain;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/13
 */
public class InfoHandler extends SimpleChannelInboundHandler<Info> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Info msg) throws Exception {
        System.out.println(msg);
    }
}

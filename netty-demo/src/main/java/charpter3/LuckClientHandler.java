package charpter3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/5/25
 */
public class LuckClientHandler extends SimpleChannelInboundHandler<LuckMessage> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LuckMessage msg) throws Exception {
        System.out.println(msg);
    }
}

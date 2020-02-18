package pers.masteryourself.study.server.netty.unpacking;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : NettyUnpackingServerHandler
 * @date : 2020/2/18 15:31
 */
public class NettyUnpackingServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        System.out.printf("服务器端第 %d 次接收数据 {%s}\n", count.incrementAndGet(), new String(msg.getContent(), CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}

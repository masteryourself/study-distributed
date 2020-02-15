package pers.masteryourself.study.server.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : NettySimpleClientHandler
 * @date : 2020/2/16 1:08
 */
public class NettySimpleClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当通道就绪会触发该方法
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello,Netty", CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端读取数据的线程：" + Thread.currentThread().getName());
        Channel channel = ctx.channel();
        ByteBuf buf = (ByteBuf) msg;
        System.out.printf("服务端 [%s] 回复的数据是：%s\n", channel.remoteAddress().toString().substring(1), buf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}

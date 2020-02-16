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
 * Description : handler 处理器
 * @date : 2020/2/16 1:08
 */
public class SimpleNettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取数据事件
     *
     * @param ctx 上下文对象
     * @param msg 客户端发送的数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器读取数据的线程：" + Thread.currentThread().getName());
        Channel channel = ctx.channel();
        // 本质上是一个双向链表，有进站出站，pipeline 包含 channel，channel 也包含 pipeline
        // channel.pipeline()
        // pipeline.channel()
        ByteBuf buf = (ByteBuf) msg;
        System.out.printf("客户端 [%s] 发送的数据是：%s\n", channel.remoteAddress().toString().substring(1), buf.toString(CharsetUtil.UTF_8));
    }

    /**
     * 数据读取完毕事件
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("服务器端接收到你的数据了", CharsetUtil.UTF_8));
    }

    /**
     * 处理异常，一般需要关闭通道
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
    }

}

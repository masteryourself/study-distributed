package pers.masteryourself.study.server.netty.task;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : handler 处理器
 * @date : 2020/2/16 1:08
 */
public class NettyTaskServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 存储所有 channel
     */
    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 在构造函数中，初始化一个定时任务，每隔 5s 推送一条消息
     */
    public NettyTaskServerHandler() {
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        pool.scheduleAtFixedRate(() -> channels.writeAndFlush(
                Unpooled.copiedBuffer("非当前 Reactor 线程调用 Channel 方法完成 1次/5s 的消息推送", CharsetUtil.UTF_8))
                , 0, 5, TimeUnit.SECONDS);
    }

    /**
     * 表示连接建立，一旦连接，第一个被执行
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 每次来一个客户端连接，都会调用此方法，所以缓存所有的 channel
        channels.add(ctx.channel());
    }

    /**
     * 读取数据事件
     * 假设 client 发出了一个查询请求，这个请求非常耗时，如果直接放在这里查询，那么 channelReadComplete 事件就会阻塞住
     * 可以考虑放在任务队列中
     *
     * @param ctx 上下文对象
     * @param msg 客户端发送的数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel = ctx.channel();
        ByteBuf buf = (ByteBuf) msg;
        System.out.printf("客户端 [%s] 发送的数据是：%s\n", channel.remoteAddress().toString().substring(1), buf.toString(CharsetUtil.UTF_8));
        // 1. 普通任务
        channel.eventLoop().execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                ctx.writeAndFlush(Unpooled.copiedBuffer("使用 channel.eventLoop().execute() 完成普通任务", CharsetUtil.UTF_8));
                System.out.println(ctx.channel().hashCode());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 2. 定时任务，延时 5s
        channel.eventLoop().schedule(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                ctx.writeAndFlush(Unpooled.copiedBuffer("使用 channel.eventLoop().schedule() 完成定时任务", CharsetUtil.UTF_8));
                System.out.println(ctx.channel().hashCode());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 5, TimeUnit.SECONDS);
    }

    /**
     * 数据读取完毕事件
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("客户端更新任务已经提交", CharsetUtil.UTF_8));
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

}

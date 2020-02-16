package pers.masteryourself.study.server.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : GroupChatServerHandler
 * @date : 2020/2/16 16:54
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * GlobalEventExecutor.INSTANCE 是全局的事件执行器，单例
     */
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 连接建立事件，第一个被执行
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush(String.format("客户端 [%s] 加入聊天室", channel.remoteAddress().toString().substring(1)));
        channelGroup.add(channel);
    }

    /**
     * 断开连接
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.writeAndFlush(String.format("客户端 [%s] 离开聊天室", ctx.channel().remoteAddress().toString().substring(1)));
        System.out.println("当前 channelGroup 大小：" + channelGroup.size());
    }

    /**
     * channel 处于活动状态，提示上线
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("客户端 [%s] 上线了", ctx.channel().remoteAddress().toString().substring(1)));
    }

    /**
     * channel 处于非活动状态，提示下线
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("客户端 [%s] 下线了", ctx.channel().remoteAddress().toString().substring(1)));
    }

    /**
     * 数据读取
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(temp -> {
            if (channel == temp) {
                temp.writeAndFlush(String.format("您发送了消息：【%s】", msg));
            } else {
                temp.writeAndFlush(String.format("客户 [%s] 发送了消息：【%s】", channel.remoteAddress().toString().substring(1), msg));
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}

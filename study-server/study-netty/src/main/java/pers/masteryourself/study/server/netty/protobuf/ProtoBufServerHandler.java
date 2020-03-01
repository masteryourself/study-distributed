package pers.masteryourself.study.server.netty.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * <p>description : ProtoBufServerHandler
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/2/17 13:41
 */
public class ProtoBufServerHandler extends SimpleChannelInboundHandler<StudentManage.Student> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentManage.Student msg) throws Exception {
        System.out.printf("客户端发送的实体对象：id 是{%s}, name 是{%s}\n", msg.getId(), msg.getName());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}

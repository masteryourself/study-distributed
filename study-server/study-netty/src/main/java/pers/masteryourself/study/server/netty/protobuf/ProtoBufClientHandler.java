package pers.masteryourself.study.server.netty.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : ProtoBufClientHandler
 * @date : 2020/2/17 13:41
 */
public class ProtoBufClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        StudentManage.Student student = StudentManage.Student.newBuilder()
                .setId(18).setName("masteryourself").build();
        ctx.writeAndFlush(student);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}

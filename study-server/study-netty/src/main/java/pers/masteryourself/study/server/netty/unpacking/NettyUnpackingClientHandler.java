package pers.masteryourself.study.server.netty.unpacking;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * <p>description : NettyUnpackingClientHandler
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/2/18 23:20
 */
public class NettyUnpackingClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 1; i <= 10; i++) {
            String msg = "\t查询" + i + "号员工信息";
            byte[] content = msg.getBytes();
            int length = msg.getBytes(CharsetUtil.UTF_8).length;
            ctx.writeAndFlush(new MessageProtocol(length, content));
            //ctx.writeAndFlush(Unpooled.copiedBuffer("\t查询" + i + "号员工信息", CharsetUtil.UTF_8));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}

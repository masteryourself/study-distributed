package pers.masteryourself.study.server.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * <p>description : NettyCodecClientHandler
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/2/18 15:32
 */
public class NettyCodecClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("先发送 byte 类型数据，不会经过编码器");
        ByteBuf buf = Unpooled.buffer(12);
        buf.writeInt(1);
        buf.writeInt(2);
        buf.writeInt(3);
        ctx.writeAndFlush(buf);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("5s 后再发送 int 类型数据，会经过编码器编码");
        ctx.writeAndFlush(145);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}

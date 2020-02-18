package pers.masteryourself.study.server.netty.unpacking;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : MessageProtocolDecoder
 * @date : 2020/2/18 23:24
 */
public class MessageProtocolDecoder extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MessageProtocolDecoder 被调用");
        int length = in.readInt();
        byte[] context = new byte[length];
        in.readBytes(context);
        out.add(new MessageProtocol(length, context));
    }

}

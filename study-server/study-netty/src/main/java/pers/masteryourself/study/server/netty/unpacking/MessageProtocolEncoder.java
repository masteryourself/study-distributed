package pers.masteryourself.study.server.netty.unpacking;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * <p>description : MessageProtocolEncoder
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/2/18 23:20
 */
public class MessageProtocolEncoder extends MessageToByteEncoder<MessageProtocol> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MessageProtocolEncoder 被调用");
        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent());
    }

}

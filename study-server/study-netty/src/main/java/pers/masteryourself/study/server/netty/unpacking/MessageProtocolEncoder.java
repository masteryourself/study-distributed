package pers.masteryourself.study.server.netty.unpacking;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : MessageProtocolEncoder
 * @date : 2020/2/18 23:30
 */
public class MessageProtocolEncoder extends MessageToByteEncoder<MessageProtocol> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MessageProtocolEncoder 被调用");
        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent());
    }

}

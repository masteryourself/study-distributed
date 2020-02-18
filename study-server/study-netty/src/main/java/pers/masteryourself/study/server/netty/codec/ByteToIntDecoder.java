package pers.masteryourself.study.server.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : ByteToIntDecoder
 * @date : 2020/2/18 15:32
 */
public class ByteToIntDecoder extends ByteToMessageDecoder {

    /**
     * 每次入站从 ByteBuf 中读取 4 字节，将其解码为一个 int，然后将它添加到下一个 List 中
     * 当没有更多元素可以被添加到该 List 中时，它的内容将会被发送给下一个 ChannelInboundHandler
     * int 在被添加到 List 中时，会被自动装箱为 Integer。在调用 readInt() 方法前必须验证所输入的 ByteBuf 是否具有足够的数据
     *
     * @param ctx
     * @param in
     * @param out
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("ByteToIntDecoder 解码器被调用");
        if (in.readableBytes() >= 4) {
            out.add(in.readInt());
        }
    }

}

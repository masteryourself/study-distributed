package pers.masteryourself.study.server.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * <p>description : HttpChannelInitializer
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/2/16 11:16
 */
public class HttpChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // HttpServerCodec 是 netty 内置的 Http 编-解码器
        ch.pipeline().addLast("httpServerCodec", new HttpServerCodec());
        ch.pipeline().addLast("nettyHttpServerHandler", new HttpServerHandler());
    }

}

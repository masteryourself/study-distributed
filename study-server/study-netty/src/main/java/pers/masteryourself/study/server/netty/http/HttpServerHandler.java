package pers.masteryourself.study.server.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : HttpServerHandler
 * @date : 2020/2/16 11:15
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpRequest) {
            ChannelPipeline pipeline = ctx.pipeline();
            System.out.printf("pipeline hashcode %d, nettyHttpServerHandler hashcode %d\n", pipeline.hashCode(), this.hashCode());
            System.out.printf("客户端地址 %s\n", ctx.channel().remoteAddress());
            HttpRequest httpRequest = (HttpRequest) msg;
            // 获取 uri
            URI uri = new URI(httpRequest.uri());
            if ("/favicon.io".equals(uri.getPath())) {
                System.out.println("请求 favicon.io，不做响应");
                return;
            }
            ByteBuf content = Unpooled.copiedBuffer("hello, 我是 http server", CharsetUtil.UTF_8);
            FullHttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            httpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            ctx.writeAndFlush(httpResponse);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}

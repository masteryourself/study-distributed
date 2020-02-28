package pers.masteryourself.study.server.netty.unpacking;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : NettyUnpackingClient
 * @date : 2020/2/18 15:31
 */
public class NettyUnpackingClient {

    public static void main(String[] args) throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            // 创建服务器启动对象，配置参数
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    // 使用 NioSocketChannel 作为客户端的通道实现
                    .channel(NioSocketChannel.class)
                    // 添加 Handler 处理器
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new MessageProtocolDecoder())
                                    .addLast(new MessageProtocolEncoder())
                                    .addLast(new NettyUnpackingClientHandler());
                        }
                    });
            System.out.println("客户端 ready ......");
            // 客户端连接服务器端地址，返回一个 channelFuture
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 7777).sync();
            // 对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

}
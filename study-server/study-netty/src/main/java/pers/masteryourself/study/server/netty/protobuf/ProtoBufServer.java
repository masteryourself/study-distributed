package pers.masteryourself.study.server.netty.protobuf;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

/**
 * <p>description : ProtoBufServer
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/2/17 13:41
 */
public class ProtoBufServer {

    public static void main(String[] args) throws Exception {
        // 创建 boosGroup，只负责连接请求，子线程 NioEventLoop 个数默认是 cpu 核数 * 2
        NioEventLoopGroup boosGroup = new NioEventLoopGroup(1);
        // 创建 workGroup，负责业务处理
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            // 创建服务器启动对象，配置参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 设置两个线程组
            serverBootstrap.group(boosGroup, workGroup)
                    // 使用 NioServerSocketChannel 作为服务端的通道实现
                    .channel(NioServerSocketChannel.class)
                    // 设置线程队列的连接个数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // 设置保持活动连接状态
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    // 添加 Handler 处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new ProtobufDecoder(StudentManage.Student.getDefaultInstance()))
                                    .addLast(new ProtoBufServerHandler());
                        }
                    });
            System.out.println("服务器 ready ......");
            // 启动服务器并绑定端口，返回一个 channelFuture
            ChannelFuture channelFuture = serverBootstrap.bind(7777).sync();
            // 对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            boosGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}

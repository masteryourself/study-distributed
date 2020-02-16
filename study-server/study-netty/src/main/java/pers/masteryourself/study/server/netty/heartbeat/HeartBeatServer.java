package pers.masteryourself.study.server.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : HeartBeatServer
 * @date : 2020/2/16 20:37
 */
public class HeartBeatServer {

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
                    // boosGroup 的 handler，日志记录
                    .handler(new LoggingHandler())
                    // 添加 Handler 处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    // readerIdleTimeSeconds: 表示多长时间没有读，就会发送一个心跳检测包检测是否连接
                                    // writerIdleTimeSeconds: 表示多长时间没有写，就会发送一个心跳检测包检测是否连接
                                    // allIdleTimeSeconds: 表示多长时间没有读写，就会发送一个心跳检测包检测是否连接
                                    // 当 IdleStateEvent 触发后，就会传递给管道的下一个 Handler 去处理，通过调用下一个 Handler 的 userEventTriggered，在该方法中进行处理
                                    .addLast(new IdleStateHandler(5, 10, 15, TimeUnit.SECONDS))
                                    .addLast(new HeartBeatServerHandler());
                        }
                    });
            System.out.println("服务器 ready ......");
            // 启动服务器并绑定端口，返回一个 channelFuture
            ChannelFuture channelFuture = serverBootstrap.bind(6666).sync();
            // 对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            boosGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

}

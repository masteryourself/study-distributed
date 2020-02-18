package pers.masteryourself.study.server.netty.groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : GroupChatClient
 * @date : 2020/2/16 16:54
 */
public class GroupChatClient {

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
                            socketChannel.pipeline().addLast(new StringDecoder())
                                    .addLast(new StringEncoder())
                                    .addLast(new GroupChatClientHandler());
                        }
                    });
            // 客户端连接服务器端地址，返回一个 channelFuture
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 7777).sync();
            Channel channel = channelFuture.channel();
            System.out.printf("******************** %s ********************\n", channel.localAddress().toString().substring(1));

            // 设置交互
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                channel.writeAndFlush(msg);
            }
        } finally {
            group.shutdownGracefully();
        }
    }

}

package com.fanfte.netty.im;

import com.fanfte.netty.im.handler.ClientHandler;
import com.fanfte.netty.im.handler.LoginResponseHandler;
import com.fanfte.netty.im.handler.MessageResponseHandler;
import com.fanfte.netty.im.message.codec.PacketCodec;
import com.fanfte.netty.im.message.codec.decode.PacketDecoder;
import com.fanfte.netty.im.message.codec.encode.PacketEncoder;
import com.fanfte.netty.im.packet.LoginResponsePacket;
import com.fanfte.netty.im.packet.MessageRequestPacket;
import com.fanfte.netty.im.util.LoginUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by tianen on 2018/9/13
 *
 * @author fanfte
 * @date 2018/9/13
 **/
public class NettyClient {

    private static int MAX_TRY = 5;

    public static void main(String[] args) {
        NioEventLoopGroup worketGroup = new NioEventLoopGroup();

        Bootstrap b = new Bootstrap();
        b.group(worketGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new PacketDecoder());
                        ch.pipeline().addLast(new LoginResponseHandler());
                        ch.pipeline().addLast(new MessageResponseHandler());
                        ch.pipeline().addLast(new PacketEncoder());
                    }
                });
        connect(b, "127.0.0.1", 8000, MAX_TRY);
    }

    public static void connect(Bootstrap b, String host, int port, int retry) {
        b.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功！");
                Channel channel = ((ChannelFuture) future).channel();
                System.out.println("channel " + channel);
                startConsoleThread(channel);
                System.out.println("线程启动成功.");
            } else {
                int order = (MAX_TRY - retry) + 1;
                int delay = 1 << order;
                System.out.println(new Date() + "连接失败,第" + order + "次重连......");
                b.config().group().schedule(() -> connect(b, host, port, retry - 1), delay, TimeUnit.SECONDS);
            }
        });
    }

    public static void startConsoleThread(Channel channel) {
        new Thread(() -> {
            while(!Thread.interrupted()) {
                if(LoginUtil.hasLogin(channel)) {
                    System.out.println("输入消息发送至服务端");
                    Scanner sc = new Scanner(System.in);
                    String line = sc.nextLine();
                    MessageRequestPacket packet = new MessageRequestPacket();
                    packet.setMessage(line);
//                    ByteBuf byteBuf = PacketCodec.getInstance().encode(packet);
                    channel.writeAndFlush(packet);
                }
            }
        }).start();
    }
}

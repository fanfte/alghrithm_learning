package com.fanfte.netty.im;

import com.fanfte.netty.im.client.handler.*;
import com.fanfte.netty.im.console.ConsoleCommandManager;
import com.fanfte.netty.im.console.LoginConsoleCommand;
import com.fanfte.netty.im.message.codec.decode.PacketDecoder;
import com.fanfte.netty.im.message.codec.encode.PacketEncoder;
import com.fanfte.netty.im.packet.response.JoinGroupResponsePacket;
import com.fanfte.netty.im.util.SessionUtil;
import io.netty.bootstrap.Bootstrap;
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
                        ch.pipeline().addLast(new LogoutResponseHandler());
                        ch.pipeline().addLast(new MessageResponseHandler());
                        ch.pipeline().addLast(new CreateGroupResponseHandler());
                        ch.pipeline().addLast(new JoinGroupResponseHandler());
                        ch.pipeline().addLast(new QuitGroupResponseHandler());
                        ch.pipeline().addLast(new ListGroupMembersResponseHandler());
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
        Scanner sc = new Scanner(System.in);
        ConsoleCommandManager mansger = new ConsoleCommandManager();
        LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();

        new Thread(() -> {
            while(!Thread.interrupted()) {
                if(!SessionUtil.hasLogin(channel)) {
                    System.out.println("输入用户名登录");
                    loginConsoleCommand.exec(sc, channel);
                } else {
                    System.out.println("输入命令");
                    mansger.exec(sc, channel);
                }
            }
        }).start();
    }
}

package com.fanfte.netty;

import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

public class EventLoopTest {

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup(2);
    }
}

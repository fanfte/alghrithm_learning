package com.fanfte.netty.im.client.handler;

import com.fanfte.netty.im.packet.response.GroupMessageResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * Created by tianen on 2018/10/9
 *
 * @author fanfte
 * @date 2018/10/9
 **/
public class SendToGroupResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket>{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket msg) throws Exception {
        String fromUsername = msg.getFromUsername();
        String message = msg.getMessage();
        System.out.println("群组" + msg.getFromGroupId() + "收到: " + fromUsername + "发来的消息: " + message);
    }
}

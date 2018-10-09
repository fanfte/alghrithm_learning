package com.fanfte.netty.im.client.handler;

import com.fanfte.netty.im.packet.response.ListGroupMembersResponsePacket;
import com.fanfte.netty.im.session.Session;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.List;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket>{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersResponsePacket msg) throws Exception {
        List<Session> sessionList = msg.getSessionList();

        System.out.println("群聊[" + msg.getGroupId() + "]中的成员包括" + msg.getSessionList());
    }
}

package com.fanfte.netty.im.server.handler;

import com.fanfte.netty.im.packet.request.ListGroupMembersRequestPacket;
import com.fanfte.netty.im.packet.response.ListGroupMembersResponsePacket;
import com.fanfte.netty.im.session.Session;
import com.fanfte.netty.im.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public class ListGroupMembersRequestHandler extends SimpleChannelInboundHandler<ListGroupMembersRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersRequestPacket msg) throws Exception {
        String groupId = msg.getGroupId();

        // 获取group中的信息
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        // 遍历组装group中的数据
        List<Session> sessionList = new ArrayList<>();
        for (Channel channel : channelGroup) {
            Session session = SessionUtil.getSession(channel);
            sessionList.add(session);
        }
        // 返回数据
        ListGroupMembersResponsePacket listGroupMembersResponsePacket = new ListGroupMembersResponsePacket();
        listGroupMembersResponsePacket.setSessionList(sessionList);
        listGroupMembersResponsePacket.setGroupId(groupId);

        ctx.channel().writeAndFlush(listGroupMembersResponsePacket);
    }
}

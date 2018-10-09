package com.fanfte.netty.im.server.handler;

import com.fanfte.netty.im.packet.request.GroupMessageRequestPacket;
import com.fanfte.netty.im.packet.response.GroupMessageResponsePacket;
import com.fanfte.netty.im.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * Created by tianen on 2018/10/9
 *
 * @author fanfte
 * @date 2018/10/9
 **/
public class GroupMessageRequestHandler extends SimpleChannelInboundHandler<GroupMessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRequestPacket msg) throws Exception {
        String toGroupId = msg.getToGroupId();

        GroupMessageResponsePacket groupMessageResponsePacket = new GroupMessageResponsePacket();
        groupMessageResponsePacket.setFromGroupId(toGroupId);
        groupMessageResponsePacket.setFromUsername(SessionUtil.getSession(ctx.channel()).getUsername());
        groupMessageResponsePacket.setMessage(msg.getMessage());

        ChannelGroup channelGroup = SessionUtil.getChannelGroup(toGroupId);
        channelGroup.writeAndFlush(groupMessageResponsePacket);
    }
}

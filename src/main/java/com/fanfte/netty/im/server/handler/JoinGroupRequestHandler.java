package com.fanfte.netty.im.server.handler;

import com.fanfte.netty.im.packet.request.JoinGroupRequestPacket;
import com.fanfte.netty.im.packet.response.JoinGroupResponsePacket;
import com.fanfte.netty.im.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket>{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket msg) throws Exception {
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.add(ctx.channel());

        JoinGroupResponsePacket joinGroupResponsePacket = new JoinGroupResponsePacket();
        joinGroupResponsePacket.setSuccess(true);
        joinGroupResponsePacket.setGroupId(groupId);
        ctx.channel().writeAndFlush(joinGroupResponsePacket);

    }
}

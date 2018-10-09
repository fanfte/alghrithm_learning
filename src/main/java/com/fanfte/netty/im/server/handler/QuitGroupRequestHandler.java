package com.fanfte.netty.im.server.handler;

import com.fanfte.netty.im.packet.request.QuitGroupRequestPacket;
import com.fanfte.netty.im.packet.response.QuitGroupResponsePacket;
import com.fanfte.netty.im.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public class QuitGroupRequestHandler extends SimpleChannelInboundHandler<QuitGroupRequestPacket>{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupRequestPacket msg) throws Exception {
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.remove(ctx.channel());

        QuitGroupResponsePacket quitGroupResponsePacket = new QuitGroupResponsePacket();
        quitGroupResponsePacket.setSuccess(true);
        quitGroupResponsePacket.setGroupId(groupId);
        ctx.channel().writeAndFlush(quitGroupResponsePacket);
    }
}

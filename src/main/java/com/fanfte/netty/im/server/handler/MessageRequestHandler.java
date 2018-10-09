package com.fanfte.netty.im.server.handler;

import com.fanfte.netty.im.packet.request.MessageRequestPacket;
import com.fanfte.netty.im.packet.response.MessageResponsePacket;
import com.fanfte.netty.im.session.Session;
import com.fanfte.netty.im.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * Created by tianen on 2018/9/16
 *
 * @author fanfte
 * @date 2018/9/16
 **/
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) throws Exception {
//        MessageResponsePacket messageResponsePacket = receiveMessage(messageRequestPacket);
//        ByteBuf responseButeBuf = PacketCodec.getInstance().encode(ctx.alloc(), messageResponsePacket);
        // 拿到消息发送方的会话信息
        Session session = SessionUtil.getSession(ctx.channel());
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMessage(messageRequestPacket.getMessage());
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUsername());

        Channel toUserChannel = SessionUtil.getChannel(messageRequestPacket.getToUserId());
        if(toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(messageResponsePacket);
            ctx.channel().writeAndFlush("发送成功");
        } else {
            System.out.println("session: " + session.getUserId() + "不在线，发送失败！");
            ctx.channel().writeAndFlush("session: " + session.getUserId() + "不在线，发送失败！");
        }
    }

    public MessageResponsePacket receiveMessage(MessageRequestPacket messageRequestPacket) {
        System.out.println(new Date() + ":收到客户端消息:" + messageRequestPacket.getMessage());
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMessage("服务端回复[" +  messageRequestPacket.getMessage() + "]");
        return messageResponsePacket;
    }
}

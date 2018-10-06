package com.fanfte.netty.im.handler;

import com.fanfte.netty.im.packet.MessageRequestPacket;
import com.fanfte.netty.im.packet.MessageResponsePacket;
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
        ctx.channel().writeAndFlush(receiveMessage(messageRequestPacket));
    }

    public MessageResponsePacket receiveMessage(MessageRequestPacket messageRequestPacket) {
        System.out.println(new Date() + ":收到客户端消息:" + messageRequestPacket.getMessage());
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMessage("服务端回复[" +  messageRequestPacket.getMessage() + "]");
        return messageResponsePacket;
    }
}

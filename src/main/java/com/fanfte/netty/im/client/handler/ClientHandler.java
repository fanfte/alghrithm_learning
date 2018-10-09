package com.fanfte.netty.im.client.handler;

import com.fanfte.netty.im.message.Packet;
import com.fanfte.netty.im.packet.request.LoginRequestPacket;
import com.fanfte.netty.im.message.codec.PacketCodec;
import com.fanfte.netty.im.packet.response.LoginResponsePacket;
import com.fanfte.netty.im.packet.response.MessageResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;
import java.util.UUID;

/**
 * Created by tianen on 2018/9/16
 *
 * @author fanfte
 * @date 2018/9/16
 **/
public class ClientHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + "： 客户端开始登录");
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("Dante");
        loginRequestPacket.setPassword("123456");

//        ByteBuf buffer = PacketCodec.getInstance().encode(loginRequestPacket);
//        ctx.channel().writeAndFlush(buffer);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodec.getInstance().decode(byteBuf);

        if(packet instanceof LoginResponsePacket) {
            LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;


        } else if(packet instanceof MessageResponsePacket) {
            MessageResponsePacket messageResponsePacket = (MessageResponsePacket) packet;
            System.out.println("收到服务端的消息-> " + messageResponsePacket);
        }
    }
}

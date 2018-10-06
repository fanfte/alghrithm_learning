package com.fanfte.netty.im.handler;

import com.fanfte.netty.im.packet.LoginRequestPacket;
import com.fanfte.netty.im.message.Packet;
import com.fanfte.netty.im.message.codec.PacketCodec;
import com.fanfte.netty.im.packet.MessageRequestPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by tianen on 2018/9/16
 *
 * @author fanfte
 * @date 2018/9/16
 **/
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf requestByteBuf = (ByteBuf) msg;
        Packet packet = PacketCodec.getInstance().decode(requestByteBuf);

        if(packet instanceof LoginRequestPacket) {

        } else if(packet instanceof MessageRequestPacket) {

        }
    }


}

package com.fanfte.netty.im.client.handler;

import com.fanfte.netty.im.packet.response.CreateGroupResponsePacket;
import com.fanfte.netty.im.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public class CreateGroupResponseHandler extends SimpleChannelInboundHandler<CreateGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupResponsePacket msg) throws Exception {
        // 去掉自己
        System.out.print("群创建成功,id为[" + msg.getGroupId() + "]");
        System.out.println("群成员有: " + msg.getUserNameList());
    }
}

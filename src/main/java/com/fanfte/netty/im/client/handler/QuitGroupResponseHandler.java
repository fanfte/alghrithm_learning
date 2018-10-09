package com.fanfte.netty.im.client.handler;

import com.fanfte.netty.im.packet.response.QuitGroupResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public class QuitGroupResponseHandler extends SimpleChannelInboundHandler<QuitGroupResponsePacket>{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupResponsePacket msg) throws Exception {
        if(msg.isSuccess()) {
            System.out.println("退出群聊[" + msg.getGroupId() + "]成功");
        } else {
            System.out.println("退出群聊[" + msg.getGroupId() + "]失败,原因为" + msg.getReason());
        }
    }
}

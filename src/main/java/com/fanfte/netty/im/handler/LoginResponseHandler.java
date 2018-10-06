package com.fanfte.netty.im.handler;

import com.fanfte.netty.im.packet.LoginRequestPacket;
import com.fanfte.netty.im.packet.LoginResponsePacket;
import com.fanfte.netty.im.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;
import java.util.UUID;

/**
 * Created by tianen on 2018/9/16
 *
 * @author fanfte
 * @date 2018/9/16
 **/
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        handleLoginResponse(ctx, loginResponsePacket);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 创建登录对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("fanfte");
        loginRequestPacket.setPassword("123456");

        // 写数据
        ctx.channel().writeAndFlush(loginRequestPacket);
    }

    public void handleLoginResponse(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) {
        if(loginResponsePacket.isSuccess()) {
            LoginUtil.markAsLogin(ctx.channel());
            System.out.println(new Date() + "-> 客户端登陆成功");
        } else {
            System.out.println(new Date() + "-> 客户端登录失败，原因:" + loginResponsePacket.getReason());
        }
    }
}

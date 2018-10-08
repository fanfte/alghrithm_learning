package com.fanfte.netty.im.server.handler;

import com.fanfte.netty.im.packet.LoginRequestPacket;
import com.fanfte.netty.im.packet.LoginResponsePacket;
import com.fanfte.netty.im.session.Session;
import com.fanfte.netty.im.util.LoginUtil;
import com.fanfte.netty.im.util.SessionUtil;
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
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {
//        LoginResponsePacket loginResponsePacket = login(msg);
//        ByteBuf responseByteBuf = PacketCodec.getInstance().encode(ctx.alloc(), loginResponsePacket);
        LoginResponsePacket loginResult = new LoginResponsePacket();
        loginResult.setVersion(msg.getVersion());
        loginResult.setUsername(msg.getUsername());
        if(valid(msg)) {
            loginResult.setSuccess(true);
            String userId = randomUserId();
            loginResult.setUserId(userId);
            System.out.println("用户 " + msg.getUsername() + " 登录成功");
            SessionUtil.bindSession(new Session(userId, msg.getUsername()), ctx.channel());
        } else {
            loginResult.setSuccess(false);
            loginResult.setReason("账号密码校验失败");
            System.out.println(new Date() + "登录失败");
        }
        ctx.channel().writeAndFlush(loginResult);
//        if(loginResult.isSuccess()) {
//            LoginUtil.markAsLogin(ctx.channel());
//        }
    }

    private String randomUserId() {
        return UUID.randomUUID().toString().split("-")[0];
    }

    private LoginResponsePacket login(LoginRequestPacket msg) {
        LoginRequestPacket loginRequestPacket = (LoginRequestPacket) msg;
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(msg.getVersion());
        if(valid(loginRequestPacket)) {
            System.out.println("客户端登录成功.");
            loginResponsePacket.setSuccess(true);
        } else {
            loginResponsePacket.setReason("用户名密码校验失败.");
            loginResponsePacket.setSuccess(false);
        }
        return loginResponsePacket;
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().split("-")[0]);
    }

}

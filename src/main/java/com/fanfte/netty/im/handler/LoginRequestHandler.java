package com.fanfte.netty.im.handler;

import com.fanfte.netty.im.packet.LoginRequestPacket;
import com.fanfte.netty.im.packet.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

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
        ctx.channel().writeAndFlush(login(msg));
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
}

package com.fanfte.netty.im;

import com.google.common.primitives.Chars;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.checkerframework.checker.units.qual.C;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * Created by tianen on 2018/9/13
 *
 * @author fanfte
 * @date 2018/9/13
 **/
public class FirstServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 接收客户端来的数据
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() + ": 服务端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));

        // 发送服务端数据
        ByteBuf sendBuf = getByteBuf(ctx, "客户端你好");
        ctx.channel().writeAndFlush(sendBuf);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().writeAndFlush(getByteBuf(ctx, "客户端注册上来的信息"));
    }

    public ByteBuf getByteBuf(ChannelHandlerContext ctx, String msg) {
        byte[] bytes = msg.getBytes(Charset.forName("utf-8"));
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes(bytes);
        return buffer;
    }
}

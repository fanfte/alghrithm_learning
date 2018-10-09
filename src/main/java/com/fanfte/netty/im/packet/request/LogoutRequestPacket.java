package com.fanfte.netty.im.packet.request;

import com.fanfte.netty.im.message.Packet;

import static com.fanfte.netty.im.message.Command.LOG_OUT_REQUEST;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return LOG_OUT_REQUEST;
    }
}

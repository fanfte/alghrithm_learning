package com.fanfte.netty.im.packet.response;

import com.fanfte.netty.im.message.Packet;
import lombok.Data;

import static com.fanfte.netty.im.message.Command.LOG_OUT_RESPONSE;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
@Data
public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return LOG_OUT_RESPONSE;
    }
}

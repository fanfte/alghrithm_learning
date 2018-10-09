package com.fanfte.netty.im.packet.response;

import com.fanfte.netty.im.message.Packet;
import lombok.Data;

import static com.fanfte.netty.im.message.Command.MESSAGE_RESPONSE;

/**
 * Created by tianen on 2018/9/16
 *
 * @author fanfte
 * @date 2018/9/16
 **/
@Data
public class MessageResponsePacket extends Packet {

    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}

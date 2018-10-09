package com.fanfte.netty.im.packet.request;

import com.fanfte.netty.im.message.Packet;
import lombok.Data;

import static com.fanfte.netty.im.message.Command.SEND_GROUP_MESSAGE_REQUEST;

/**
 * Created by tianen on 2018/10/9
 *
 * @author fanfte
 * @date 2018/10/9
 **/
@Data
public class GroupMessageRequestPacket extends Packet {

    private String toGroupId;

    private String message;

    @Override
    public Byte getCommand() {
        return SEND_GROUP_MESSAGE_REQUEST;
    }
}

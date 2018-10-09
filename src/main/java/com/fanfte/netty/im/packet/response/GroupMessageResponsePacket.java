package com.fanfte.netty.im.packet.response;

import com.fanfte.netty.im.message.Packet;
import lombok.Data;

import static com.fanfte.netty.im.message.Command.SEND_GROUP_MESSAGE_RESPONSE;

/**
 * Created by tianen on 2018/10/9
 *
 * @author fanfte
 * @date 2018/10/9
 **/
@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromUsername;

    private String message;

    private String fromGroupId;

    @Override
    public Byte getCommand() {
        return SEND_GROUP_MESSAGE_RESPONSE;
    }
}

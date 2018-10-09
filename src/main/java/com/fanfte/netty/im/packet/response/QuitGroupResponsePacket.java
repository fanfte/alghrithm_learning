package com.fanfte.netty.im.packet.response;

import com.fanfte.netty.im.message.Packet;
import lombok.Data;

import static com.fanfte.netty.im.message.Command.QUIT_GROUP_RESPONSE;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
@Data
public class QuitGroupResponsePacket extends Packet {

    private String reason;

    private boolean success;

    private String groupId;

    @Override
    public Byte getCommand() {
        return QUIT_GROUP_RESPONSE;
    }
}

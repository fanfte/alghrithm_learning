package com.fanfte.netty.im.packet.response;

import com.fanfte.netty.im.message.Packet;
import lombok.Data;

import java.util.List;

import static com.fanfte.netty.im.message.Command.CREATE_GROUP_RESPONSE;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
@Data
public class CreateGroupResponsePacket extends Packet {

    private boolean success;

    private String reason;

    private List<String> userNameList;

    private String groupId;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_RESPONSE;
    }
}

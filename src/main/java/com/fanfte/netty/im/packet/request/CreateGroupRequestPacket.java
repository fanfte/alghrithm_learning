package com.fanfte.netty.im.packet.request;

import com.fanfte.netty.im.message.Packet;
import lombok.Data;

import java.util.List;

import static com.fanfte.netty.im.message.Command.CREATE_GROUP_REQUEST;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_REQUEST;
    }
}

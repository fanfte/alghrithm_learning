package com.fanfte.netty.im.packet.response;

import com.fanfte.netty.im.message.Packet;
import com.fanfte.netty.im.session.Session;
import lombok.Data;

import java.util.List;

import static com.fanfte.netty.im.message.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
@Data
public class ListGroupMembersResponsePacket extends Packet {

    private List<Session> sessionList;

    private String groupId;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}

package com.fanfte.netty.im.packet.request;

import com.fanfte.netty.im.message.Packet;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.Data;

import static com.fanfte.netty.im.message.Command.QUIT_GROUP_REQUEST;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return QUIT_GROUP_REQUEST;
    }
}

package com.fanfte.netty.im.packet.request;

import com.fanfte.netty.im.message.Packet;
import lombok.Data;

import static com.fanfte.netty.im.message.Command.MESSAGE_REQUEST;

/**
 * Created by tianen on 2018/9/16
 *
 * @author fanfte
 * @date 2018/9/16
 **/
@Data
public class MessageRequestPacket extends Packet{

    private String message;

    private String toUserId;

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }

    @Override
    public String toString() {
        return "MessageRequestPacket{" +
                "message='" + message + '\'' +
                ", toUserId='" + toUserId + '\'' +
                '}';
    }

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }
}

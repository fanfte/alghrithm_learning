package com.fanfte.netty.im.packet.request;

import com.fanfte.netty.im.message.Packet;
import lombok.Data;

import static com.fanfte.netty.im.message.Command.LOGIN_REQUEST;

/**
 * Created by tianen on 2018/9/14
 *
 * @author fanfte
 * @date 2018/9/14
 **/
@Data
public class LoginRequestPacket extends Packet {

    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}

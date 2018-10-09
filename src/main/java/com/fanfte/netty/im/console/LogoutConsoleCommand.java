package com.fanfte.netty.im.console;

import com.fanfte.netty.im.packet.request.LogoutRequestPacket;
import com.fanfte.netty.im.session.Session;
import com.fanfte.netty.im.util.SessionUtil;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public class LogoutConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
        channel.writeAndFlush(logoutRequestPacket);
    }
}

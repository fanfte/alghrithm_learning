package com.fanfte.netty.im.console;

import com.fanfte.netty.im.packet.request.MessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}

package com.fanfte.netty.im.console;

import com.fanfte.netty.im.packet.request.CreateGroupRequestPacket;
import com.fanfte.netty.im.session.Session;
import com.fanfte.netty.im.util.SessionUtil;
import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public class CreateGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        CreateGroupRequestPacket createGroupRequestPacket = new CreateGroupRequestPacket();
        String command = scanner.next();
        List<String> userIds = new ArrayList<>(Arrays.asList(command.split(",")));
        Session session = SessionUtil.getSession(channel);
        if(session != null) {
            userIds.add(session.getUserId());
        }
        createGroupRequestPacket.setUserIdList(userIds);
        channel.writeAndFlush(createGroupRequestPacket);
    }
}

package com.fanfte.netty.im.console;

import com.fanfte.netty.im.packet.request.LoginRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public class LoginConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        String username = scanner.nextLine();
        loginRequestPacket.setUsername(username);
        loginRequestPacket.setPassword("pwd");
        channel.writeAndFlush(loginRequestPacket);
        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

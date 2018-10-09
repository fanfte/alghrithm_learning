package com.fanfte.netty.im.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}

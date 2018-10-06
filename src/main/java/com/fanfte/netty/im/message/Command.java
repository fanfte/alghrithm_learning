package com.fanfte.netty.im.message;

/**
 * Created by tianen on 2018/9/14
 *
 * @author fanfte
 * @date 2018/9/14
 **/
public interface Command {

    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;
}

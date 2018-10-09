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

    Byte LOG_OUT_REQUEST = 5;

    Byte LOG_OUT_RESPONSE = 6;

    Byte CREATE_GROUP_REQUEST = 7;

    Byte CREATE_GROUP_RESPONSE = 8;

    Byte JOIN_GROUP_REQUEST = 9;

    Byte JOIN_GROUP_RESPONSE = 10;

    Byte QUIT_GROUP_REQUEST = 11;

    Byte QUIT_GROUP_RESPONSE = 12;

    Byte LIST_GROUP_MEMBERS_REQUEST = 13;

    Byte LIST_GROUP_MEMBERS_RESPONSE = 14;
}

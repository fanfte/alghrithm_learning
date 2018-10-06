package com.fanfte.netty.im.message;

import lombok.Data;

/**
 * Created by tianen on 2018/9/14
 *
 * @author fanfte
 * @date 2018/9/14
 **/
@Data
public abstract class Packet {

    private Byte version = 1;

    public abstract Byte getCommand();
}

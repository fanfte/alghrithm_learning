package com.fanfte.netty.im.attribute;

import com.fanfte.netty.im.session.Session;
import io.netty.util.AttributeKey;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public class Attributes {
    public static AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}

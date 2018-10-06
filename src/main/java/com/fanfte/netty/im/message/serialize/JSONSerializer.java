package com.fanfte.netty.im.message.serialize;

import com.alibaba.fastjson.JSON;

/**
 * Created by tianen on 2018/9/14
 *
 * @author fanfte
 * @date 2018/9/14
 **/
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}

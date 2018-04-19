package com.fanfte.designPattern.decorator;

import java.util.Date;

public class PacketHTTPHeaderCreator extends PacketDecorator {

    public PacketHTTPHeaderCreator(IPackeetCreator component) {
        super(component);
    }

    @Override
    public String handleContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("Cache-Control:no-cache\n");
        sb.append(new Date() + "\n");
        sb.append(component.handleContent());
        return sb.toString();
    }
}

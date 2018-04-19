package com.fanfte.designPattern.decorator;

public abstract class PacketDecorator implements IPackeetCreator{
    IPackeetCreator component = null;

    public PacketDecorator(IPackeetCreator component) {
        this.component = component;
    }
}

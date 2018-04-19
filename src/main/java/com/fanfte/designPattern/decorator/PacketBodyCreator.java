package com.fanfte.designPattern.decorator;

public class PacketBodyCreator implements IPackeetCreator {
    @Override
    public String handleContent() {
        return " my content message ";
    }
}

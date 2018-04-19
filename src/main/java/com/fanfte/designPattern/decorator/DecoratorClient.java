package com.fanfte.designPattern.decorator;

public class DecoratorClient {

    public static void main(String[] args) {
        PacketDecorator d = new PacketHTTPHeaderCreator(new PacketHTMLHeaderCreator(new PacketBodyCreator()));
        System.out.println(d.handleContent());
    }
}

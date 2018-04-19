package com.fanfte.designPattern.builder;

public class Director {

    public void constructor(Builder builder) {
        builder.buildMainBoard();
        builder.buildCPU();
        builder.buildHD();
    }
}

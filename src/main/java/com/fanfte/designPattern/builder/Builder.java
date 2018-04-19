package com.fanfte.designPattern.builder;

public abstract class Builder {

    public abstract void buildCPU();

    public abstract void buildMainBoard();

    public abstract void buildHD();

    public abstract Computer getComputer();
}

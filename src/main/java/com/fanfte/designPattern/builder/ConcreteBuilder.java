package com.fanfte.designPattern.builder;

public class ConcreteBuilder extends Builder {

    Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.add("组装CPU");
    }

    @Override
    public void buildMainBoard() {
        computer.add("组装主板");
    }

    @Override
    public void buildHD() {
        computer.add("组装硬盘");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

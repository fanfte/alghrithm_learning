package com.fanfte.designPattern.builder;

public class BuilderMain {

    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new ConcreteBuilder();

        director.constructor(builder);

        Computer computer = builder.getComputer();
        computer.show();
    }
}

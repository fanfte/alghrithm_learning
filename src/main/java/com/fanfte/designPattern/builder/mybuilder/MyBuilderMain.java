package com.fanfte.designPattern.builder.mybuilder;

public class MyBuilderMain {

    public static void main(String[] args) {
        MyDirector director = new MyDirector();
        Animal animal = director.construct(new MyConcreteBuilder());
        System.out.println(animal);
    }
}

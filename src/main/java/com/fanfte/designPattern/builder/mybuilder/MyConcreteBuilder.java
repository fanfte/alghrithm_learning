package com.fanfte.designPattern.builder.mybuilder;

public class MyConcreteBuilder extends MyBuilder {

    Animal animal = new Animal();

    @Override
    public void buildHead() {
        System.out.println("build animal head");
        animal.setHead("head");
    }

    @Override
    public void buildBody() {
        System.out.println("build animal body");
        animal.setBody("body");
    }

    @Override
    public void buildLegs() {
        System.out.println("build animal legs");
        animal.setLegs("legs");
    }

    @Override
    public Animal getAnimal() {
        return animal;
    }
}

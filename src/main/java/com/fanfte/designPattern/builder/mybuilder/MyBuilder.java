package com.fanfte.designPattern.builder.mybuilder;

public abstract class MyBuilder {

    public abstract void buildHead();

    public abstract void buildBody();

    public abstract void buildLegs();

    /**
     *
     * @return
     */
    public abstract Animal getAnimal();
}

package com.fanfte.designPattern.builder.mybuilder;

import com.fanfte.designPattern.builder.Builder;

public class MyDirector {

    public Animal construct(MyBuilder builder) {
        builder.buildBody();
        builder.buildHead();
        builder.buildLegs();
        return builder.getAnimal();
    }

}

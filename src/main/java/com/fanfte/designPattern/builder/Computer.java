package com.fanfte.designPattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<String> parts  = new ArrayList<>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        for (int i = 0; i < parts.size(); i++) {
            System.out.println("组件" + parts.get(i) + "装好了");
        }
    }

}

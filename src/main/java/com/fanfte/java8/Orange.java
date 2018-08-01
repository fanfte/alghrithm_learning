package com.fanfte.java8;

/**
 * Created by dell on 2018/8/1
 **/
public class Orange extends Fruit {

    private int weight;

    private String color;

    public Orange(int weight) {
        this.weight = weight;
    }

    public Orange() {
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}

package com.fanfte.java8;

/**
 * Created by dell on 2018/7/30
 **/
public class Apple extends Fruit{

    // 颜色
    private String color;

    // 重量
    private int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Apple() {
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public static boolean isGreenApple(Apple a) {
        return "green".equals(a.getColor());
    }

    public static boolean isHeavyApple(Apple a) {
        return a.getWeight() > 150;
    }


}

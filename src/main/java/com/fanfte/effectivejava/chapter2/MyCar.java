package com.fanfte.effectivejava.chapter2;

import java.math.BigDecimal;

public class MyCar implements Cloneable{

    private String brand;

    private long length;

    private long weight;

    private BigDecimal price;



    @Override
    protected MyCar clone() throws CloneNotSupportedException {
        return (MyCar)super.clone();
    }

    public MyCar(String brand, long length, long weight, BigDecimal price) {
        this.brand = brand;
        this.length = length;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return "brand " + this.brand + " length " + this.length
                +" weight " + this.weight + " price " + this.price;
    }

    public static void main(String[] args) {
        try {
            MyCar clone = new MyCar("Ford", 2, (long) 33.40, BigDecimal.valueOf(20.01)).clone();
            System.out.println(clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

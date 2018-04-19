package com.fanfte.designPattern.dynamicProxy;

public class ConcreteFishSeller implements FishSeller {
    @Override
    public int sellFish() {
        System.out.println("fish seller concrete ");
        return 10;
    }
}

package com.fanfte.designPattern.dynamicProxy;

public class ProxyFishSeller implements FishSeller {

    private FishSeller seller;

    public ProxyFishSeller(FishSeller seller) {
        this.seller = seller;
    }

    @Override
    public int sellFish() {
        System.out.println("proxy fish seller ");
        return seller.sellFish() + 10;
    }
}

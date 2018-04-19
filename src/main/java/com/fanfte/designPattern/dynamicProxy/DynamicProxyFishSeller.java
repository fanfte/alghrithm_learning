package com.fanfte.designPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyFishSeller implements InvocationHandler {

    private FishSeller seller;

    public DynamicProxyFishSeller(FishSeller seller) {
        this.seller = seller;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Dynamic proxy fish seller.");

        return (Integer) method.invoke(seller, args) + 10;
    }

    public static class ClientTest {
        public static void main(String[] args) {
            FishSeller s = new ConcreteFishSeller();
            InvocationHandler proxyFishSeller = new DynamicProxyFishSeller(s);
            Object o = Proxy.newProxyInstance(s.getClass().getClassLoader(), s.getClass().getInterfaces(), proxyFishSeller);
            ((FishSeller)o).sellFish();
        }
    }
}

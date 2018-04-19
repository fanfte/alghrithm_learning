package com.fanfte.designPattern.strategy;

public class TestCash {

    public static void main(String[] args) {
        CashContext cc = new CashContext("满减");
        double result = cc.getResult(700);
        System.out.println(result);

        MyRun r = new MyRun();
        r.run();
    }

    static class MyRun implements Runnable {

        @Override
        public void run() {

        }
    }
}

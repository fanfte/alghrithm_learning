package com.fanfte.designPattern.strategy;

public class CashContext {

    private CashSuper cs;

    public CashContext(String type) {
        switch (type) {
            case "正常收费":
                cs = new CashNormal();
            break;
            case "满减":
                cs = new CashReturn(300, 100);
                break;
            case "打折":
                cs = new CashRebate(0.8);
                break;
        }
    }

    public double getResult(double money) {
        return cs.acceptCash(money);
    }
}

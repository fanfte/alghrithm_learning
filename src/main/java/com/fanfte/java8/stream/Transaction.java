package com.fanfte.java8.stream;

/**
 * Created by dell on 2018/8/1
 **/
public class Transaction {

    private final int year;

    private final int value;

    private final Trader trader;
    public Transaction(Trader trader, int year, int value) {
        this.year = year;
        this.value = value;
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    public Trader getTrader() {
        return trader;
    }

    @Override
    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " +
                "value: "+ this.value + "}";
    }
}

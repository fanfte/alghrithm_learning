package com.fanfte.designPattern.simpleFactory;

public class OperationAdd extends Operation{
    @Override
    public double getResult() {
        double result = 0.0;
        result = getNumA() + getNumB();
        return result;
    }
}

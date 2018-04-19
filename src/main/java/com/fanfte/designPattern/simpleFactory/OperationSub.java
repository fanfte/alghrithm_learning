package com.fanfte.designPattern.simpleFactory;

public class OperationSub extends Operation{
    @Override
    public double getResult() {
        double result = 0.0;
        result = getNumA() - getNumB();
        return result;
    }
}

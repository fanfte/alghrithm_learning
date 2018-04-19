package com.fanfte.designPattern.simpleFactory;

public class OperationMul extends Operation{
    @Override
    public double getResult() {
        double result = 0.0;
        result = getNumA() * getNumB();
        return result;
    }
}

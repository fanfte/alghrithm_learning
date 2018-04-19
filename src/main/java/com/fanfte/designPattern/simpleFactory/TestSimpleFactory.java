package com.fanfte.designPattern.simpleFactory;

public class TestSimpleFactory {

    public static void main(String[] args) {
        Operation operation = OperationFactory.createOperation("*");
        operation.setNumA(4);
        operation.setNumB(9);
        double result = operation.getResult();
        System.out.println(result);
    }
}

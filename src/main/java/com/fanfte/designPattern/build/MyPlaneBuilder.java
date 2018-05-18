package com.fanfte.designPattern.build;

public class MyPlaneBuilder implements GenericBuilder<MyPlane>{
    private static String poliet;

    private static String driver;

    private static String wings;

    private static String tail;

    @Override
    public MyPlane build() {
        return null;
    }

    public MyPlaneBuilder self() {
        return this;
    }

    public static void wings(String val) {
        wings = val;
    }

    public void poliet(String val) {
        poliet = val;
    }

    public void driver(String val) {
        driver = val;
    }

    public void tail(String val) {
        tail = val;
    }
}

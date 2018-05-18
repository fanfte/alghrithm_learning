package com.fanfte.designPattern.build;


public class MyPlane {

    private final String poliet;

    private final String driver;

    private final String wings;

    private final String tail;

    public MyPlane(MyPlaneBuilder builder) {
        this.poliet = builder.poliet;
        this.driver = builder.driver;
        this.wings = builder.wings;
        this.tail = builder.tail;
    }

    public static class MyPlaneBuilder implements GenericBuilder<MyPlane>{
        private String poliet;

        private String driver;

        private String wings;

        private String tail;

        @Override
        public MyPlane build() {
            return new MyPlane(this);
        }

        public MyPlaneBuilder() {

        }

        public MyPlaneBuilder wings(String val) {
            wings = val;
            return this;
        }

        public MyPlaneBuilder poliet(String val) {
            poliet = val;
            return this;
        }

        public MyPlaneBuilder driver(String val) {
            driver = val;
            return this;
        }

        public MyPlaneBuilder tail(String val) {
            tail = val;
            return this;
        }
    }

    public static void main(String[] args) {
    }
}

package com.fanfte.spring.aop;

/**
 * Created by tianen on 2019/3/25
 *
 * @author fanfte
 * @date 2019/3/25
 **/
public class TestBean {

    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test() {
        System.out.println("test");
    }
}

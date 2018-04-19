package com.fanfte.designPattern.builder.mybuilder;

public class Animal {

    private String head;

    private String body;

    private String legs;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "head : " + head + " body " + body + " legs " + legs;
    }
}

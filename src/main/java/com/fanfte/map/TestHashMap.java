package com.fanfte.map;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    String name;

    public TestHashMap(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Map<TestHashMap, String> map = new HashMap<>();
        TestHashMap obj = new TestHashMap("sdsd");
        map.put(obj, "name");
        String hello = map.get(obj);
        System.out.println(hello);
    }
}

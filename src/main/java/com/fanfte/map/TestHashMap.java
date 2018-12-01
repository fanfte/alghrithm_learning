package com.fanfte.map;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    String name;

    public TestHashMap(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("aaa", "111");
        map.put("aaa", "222");
        System.out.println(map);
    }
}

package com.fanfte.map;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    public static void main(String[] args) {

        System.out.println("ss");
        Map<String, String> map = new HashMap<String, String>(16, 0.75f);
        map.put("aaa", "111");
        map.put("aaa", "222");
        System.out.println(map);
    }
}

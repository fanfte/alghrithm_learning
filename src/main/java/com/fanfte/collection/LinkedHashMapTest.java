package com.fanfte.collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by tianen on 2019/3/29
 *
 * @author fanfte
 * @date 2019/3/29
 **/
public class LinkedHashMapTest {

    public static void main(String[] args) {
        Map<Integer, String> m = new LinkedHashMap<>();
        m.put(1, "a");
        m.put(2, "b");
        m.put(3, "c");
        m.put(4, "d");
        m.put(5, "e");
        m.put(6, "f");

        m.put(3, "cc");
        Set<Map.Entry<Integer, String>> entries = m.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry);
        }
        System.out.println();
        Map<Integer, String> m2 = new LinkedHashMap<>(16, 0.75f, true);
        m2.put(1, "aa");
        m2.put(2, "bb");
        m2.put(3, "cc");
        m2.put(4, "dd");
        printMap(m2);
        System.out.println(m2.get(3));
        printMap(m2);
        System.out.println(m2.get(2));
        printMap(m2);
    }

    public static void printMap(Map<Integer, String> map) {
        System.out.println(map);
    }
}

package com.fanfte.testGenerics;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

public class TestGenerics<V> {

    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        String[] result = new String[list.size()];
        result = list.toArray(result);
        System.out.println(result[1] + " " + result.length);


        String[] str = new String[] { "you", "wu" };
        List list2 = Arrays.asList(str);
//        list2.add("222");
        str[0] = "ccc";
        System.out.println();

//        List<String> a = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        for (String item : list) {
//            if ("2".equals(item)) {
//                list.remove(item);
//            }
//        }

        System.out.println();

        Map<String, String> map = new HashMap<>();
        map.put("111", "aaa");
        map.put("222", "bbb");
        map.put("333", "ccc");
        map.forEach((k,v)-> {
            System.out.println(k + " : " + v);
            if("222".equals(k)) {
                System.out.println("hello");
            }
        });

        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        for(int i = 0;i < 10;i++) {
            System.out.println(tlr.nextDouble(100));
        }

        LongAdder la = new LongAdder();
        for (int i = 0; i < 10; i++) {
            la.increment();
        }
        System.out.println(la.intValue());

    }
}

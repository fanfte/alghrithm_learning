package com.fanfte.java8;

import java.util.*;

/**
 * Created by dell on 2018/8/7
 **/
public class Test1 {

    public static void main(String[] args) {
        int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        String convert = stringConverter.convert(2);
        System.out.println(convert);

        Optional<String> optional = Optional.of("bam");
        boolean present = optional.isPresent();
        String s = optional.get();
        String adsd = optional.orElse("adsd");
        System.out.println(adsd);



        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection.stream()
                        .filter((b) -> b.startsWith("a"))
                        .sorted()
                        .forEach(System.out::println);

        stringCollection.stream()
                        .map(String::toUpperCase)
                        .sorted(Comparator.reverseOrder())
                        .forEach(System.out::println);

        boolean a = stringCollection.stream()
                .anyMatch((str) -> str.startsWith("a"));
        System.out.println(a);

        boolean b = stringCollection.stream()
                .allMatch((str) -> str.startsWith("a"));
        System.out.println(b);

        long vv = stringCollection.stream()
                .filter((cc) -> cc.startsWith("vv"))
                .count();
        System.out.println(vv);

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((id, val) -> System.out.println(val));

        String s1 = map.computeIfPresent(3, (n, val) -> val + n);
        System.out.println("s1 " + s1);
        String s2 = map.get(100);
        System.out.println(s2);

        String s3 = map.computeIfPresent(9, (n2, v) -> null);
        System.out.println(map.containsKey(9));
    }
}

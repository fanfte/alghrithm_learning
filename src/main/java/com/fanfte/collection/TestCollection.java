package com.fanfte.collection;

import java.util.*;

public class TestCollection {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("a");
        treeSet.add("b");

        Iterator<String> iterator = treeSet.iterator();
        System.out.println(treeSet);
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        Set<String> hashSet = new HashSet<>();
        hashSet.add("add");
        hashSet.add("abb");
        System.out.println(hashSet);


        Map<String, String> m = new LinkedHashMap<String, String>();
        m.put("113", "aaa");
        m.put("222", "bbb");
        m.put("323", "ccc");
        m.put("424", "ddd");
        m.get("323");
        for(Iterator i = m.keySet().iterator();i.hasNext();) {
            String name = (String)i.next();
//            System.out.println(name + "  ->  " + m.get(name));
        }

        Map<Student, String> treeMap = new TreeMap<Student, String>();
        Student s1 = new Student(90, "John");
        Student s2 = new Student(77, "Mary");
        Student s3 = new Student(84, "Jack");
        Student s4 = new Student(67, "James");
        Student s5 = new Student(99, "Kobe");

        treeMap.put(s1, "detail1");
        treeMap.put(s2, "detail2");
        treeMap.put(s3, "detail3");
        treeMap.put(s4, "detail4");
        treeMap.put(s5, "detail5");
        Map m1 = ((TreeMap) treeMap).subMap(s3, s4);
        Iterator i1 = m1.keySet().iterator();
        while(i1.hasNext()) {
            Student key = (Student) i1.next();
            System.out.println(key + " -> " + treeMap.get(key));
        }
    }
}

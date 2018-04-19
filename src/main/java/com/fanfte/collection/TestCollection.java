package com.fanfte.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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
    }
}

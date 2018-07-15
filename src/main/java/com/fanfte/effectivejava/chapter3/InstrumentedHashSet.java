package com.fanfte.effectivejava.chapter3;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    public InstrumentedHashSet() {

    }
    public InstrumentedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E o) {
        addCount ++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> set = new InstrumentedHashSet();
        set.addAll(Arrays.asList("aaa", "bbb", "ccc"));
        System.out.println(set.getAddCount());
        System.out.println("finished");
    }
}

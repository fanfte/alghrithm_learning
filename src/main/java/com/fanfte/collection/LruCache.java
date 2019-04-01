package com.fanfte.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tianen on 2019/3/29
 *
 * @author fanfte
 * @date 2019/3/29
 **/
public class LruCache<K, V> extends LinkedHashMap<K, V> {

    private int maxSize;

    public LruCache(int maxSize) {
        super(16, 0.75f, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }

    public static void main(String[] args) {
        LruCache<Integer, String> lru = new LruCache<>(5);
        lru.put(1, "a");
        lru.put(2, "b");
        lru.put(3, "c");
        lru.put(4, "d");
        lru.put(5, "e");
        System.out.println(lru);
        lru.get(3);
        System.out.println(lru);
        lru.put(6, "f");
        System.out.println(lru);

    }
}

package com.fanfte.algorithm.map;

/**
 * Created by tianen on 2018/11/15
 *
 * @author fanfte
 * @date 2018/11/15
 **/
public interface Map<K, V> {

    void add(K k, V v);
    V remove(K k);
    void set(K k, V v);
    V get(K k);
    int getSize();
    boolean isEmpty();
    boolean contains(K k);
}

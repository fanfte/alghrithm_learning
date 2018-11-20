package com.fanfte.algorithm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2018/11/19
 *
 * @author fanfte
 * @date 2018/11/19
 **/
public class MaxHeap<E extends Comparable> {
    private List<E> data;

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public int parent(int index) {
        if(index == 0) {
            throw new IllegalArgumentException("index 0 doesn`t has a parent");
        }
        return (index - 1) / 2;
    }

    public int leftChiild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    private void siftUp(int index) {
        while(index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0 ) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    public E findMax() {
        if(data.size() == 0) {
            throw new IllegalArgumentException("heap doesn`t has an element.");
        }
        return data.get(0);
    }

    public E extractMax() {
        E max = findMax();
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        siftDown(0);
        return max;
    }

    private void siftDown(int index) {
        while(leftChiild(index) < data.size() - 1) {
            int j = leftChiild(index);
            if(j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j ++;
            }
            if(data.get(index).compareTo(data.get(j)) > 0) {
                break;
            }
            swap(index, j);
            index = j;
        }
    }

    /**
     * 取出最大元素，并替换
     */
    public E replace(E e) {
        if(data.size() == 0) {
            throw new IllegalArgumentException("heap doesn`t has an element.");
        }
        E max = findMax();
        data.set(0, e);
        siftDown(0);
        return max;
    }

    private void swap(int parent, int index) {
        E temp = data.get(parent);
        data.set(parent, data.get(index));
        data.set(index, temp);
    }
}

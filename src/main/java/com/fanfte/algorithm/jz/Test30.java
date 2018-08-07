package com.fanfte.algorithm.jz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/8/3
 **/
public class Test30 {

    public static class MaxHeap<T extends Comparable> {
        private List<T> items;

        private int cursor;

        public MaxHeap() {
            new MaxHeap(32);
        }

        public MaxHeap(int capacity) {
            items = new ArrayList<>();
            cursor = -1;
        }

        public T first() {
            if(items.size() == 0) {
                throw new RuntimeException("No element.");
            }
            return items.get(0);
        }

        public boolean hasNext() {
            cursor ++;
            return cursor < items.size();
        }

        public T getNext() {
            if(cursor > items.size() - 1) {
                throw new RuntimeException("No next");
            }
            return items.get(++ cursor);
        }

        /**
         * 向上调整某个元素
         * @param index
         */
        public void siftUp(int index) {
            T intent = items.get(index);
            while(index > 0) {
                int parentIndex = (index - 1) >> 1;
                T parent = items.get(parentIndex);
                if(intent.compareTo(parent) > 0) {
                    items.set(index, parent);
                    index = parentIndex;
                } else {
                    break;
                }
            }
            items.set(index, intent);
        }

        public void siftDown(int index) {
            T intent = items.get(index);
            int leftIndex = 2 * index + 1;
            while(leftIndex < items.size()) {
                T leftChild = items.get(leftIndex);
                int maxIndex = leftIndex;

                int rightIndex = leftIndex + 1;
                T maxChild = leftChild;

                if(rightIndex < items.size()) {
                    T rightChild = items.get(rightIndex);
                    if(rightChild.compareTo(leftChild) > 0) {
                        maxIndex = rightIndex;
                        maxChild = rightChild;
                    }
                }

                if(maxChild.compareTo(intent) > 0) {
                    items.set(index, maxChild);
                    index = maxIndex;
                    leftIndex = 2 * index + 1;
                } else {
                    break;
                }
            }
            items.set(index, intent);
        }

        public void add(T item) {
            items.add(item);
            siftUp(items.size() - 1);
        }

        public T deleteTop() {
            if(items.isEmpty()) {
                throw new RuntimeException("The heap is empty");
            }

            T result = items.get(0);
            T lastElement = items.remove(items.size() - 1);
            if(items.isEmpty()) {
                return result;
            }
            items.set(0, lastElement);
            siftDown(0);
            return result;
        }

        public int size() {
            return items.size();
        }
    }

    public static void main(String[] args) {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] leastKNums = getLeastKNums(data, 4);
        printList(leastKNums);
    }

    private static void printList(int[] leastKNums) {
        for(int i =0; i < leastKNums.length;i++) {
            System.out.print(leastKNums[i] + " ");
        }
    }

    public static int[] getLeastKNums(int[] input, int k) {
        int[] result = new int[k];
        if(input == null || input.length == 0 || k <= 0) {
            throw new RuntimeException("invalid args");
        }
        MaxHeap<Integer> maxHeap = new MaxHeap<>(k);
        for(int i = 0;i < input.length ;i ++) {
            if(maxHeap.size() < k) {
                maxHeap.add(input[i]);
            } else {
                int max = maxHeap.first();
                if(max > input[i]) {
                    maxHeap.deleteTop();
                    maxHeap.add(input[i]);
                }
            }
        }
        for(int i = 0;i < result.length; i++) {
            result[i] = maxHeap.getNext();
        }
        return result;
    }
}

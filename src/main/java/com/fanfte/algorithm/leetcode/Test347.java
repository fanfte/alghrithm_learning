package com.fanfte.algorithm.leetcode;

import java.util.*;

/**
 * Created by tianen on 2018/11/20
 *
 * @author fanfte
 * @date 2018/11/20
 **/
public class Test347 {

    public static void main(String[] args) {

    }

//    public class Freq implements Comparable<Freq> {
//        private int e;
//        private int freq;
//
//        public Freq(int e, int freq) {
//            this.e = e;
//            this.freq = freq;
//        }
//
//
//        @Override
//        public int compareTo(Freq o) {
//            if(this.freq < o.freq) {
//                return -1;
//            } else if(this.freq > o.freq) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for(int key : map.keySet()) {
            if(pq.size() < k) {
                pq.add(key);
            } else {
                if(map.get(key) > map.get(pq.peek())) {
                    pq.remove();
                    pq.add(key);
                }
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }
}

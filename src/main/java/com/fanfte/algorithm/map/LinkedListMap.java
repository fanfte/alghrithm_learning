package com.fanfte.algorithm.map;

/**
 * Created by tianen on 2018/11/15
 *
 * @author fanfte
 * @date 2018/11/15
 **/
public class LinkedListMap<K, V> implements Map<K, V> {

    class Node {
        public K key;
        public V value;
        public Node next;

        public Node() {
        }

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key) {
            this.key = key;
            this.value = null;
        }

        @Override
        public String toString() {
            return key + " : " + value;
        }
    }

    private Node dummyHead;

    private int size;

    public Node getNode(K k) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if(cur.key.equals(k)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public LinkedListMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    @Override
    public void add(K k, V v) {
        Node node = getNode(k);
        if(node != null) {
            node.value = v;
        } else {
            dummyHead.next = new Node(k,v, dummyHead.next.next);
            size ++;
        }
    }

    @Override
    public V remove(K k) {
        Node cur = dummyHead;
        while(cur.next != null) {
            if(cur.next.key.equals(k)) {
                break;
            }
            cur = cur.next;
        }
        if(cur.next != null) {
            Node delNode = cur.next;
            cur.next = cur.next.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
        if(node != null) {
            node.value = v;
        } else {
            throw new IllegalArgumentException(k + " doesn`t exist!");
        }
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        return node == null ? null : node.value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(K k) {
        Node node = getNode(k);
        return node != null;
    }
}

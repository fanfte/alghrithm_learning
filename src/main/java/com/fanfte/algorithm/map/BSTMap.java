package com.fanfte.algorithm.map;

/**
 * Created by tianen on 2018/11/15
 *
 * @author fanfte
 * @date 2018/11/15
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    class Node {
        public Node left;
        public Node right;
        public K key;
        public V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        this.root = null;
        size = 0;
    }

    private Node getNode(K k) {
        return getNode(root, k);
    }

    private Node getNode(Node node, K k) {
        if(node == null) {
            return null;
        }
        if(k.compareTo(node.key) < 0) {
            return getNode(node.left, k);
        } else if(k.compareTo(node.key) > 0) {
            return getNode(node.right, k);
        } else {
            return node;
        }
    }

    @Override
    public void add(K k, V v) {
        root = add(root, k, v);
    }

    /**
     * 往node为根节点的树中添加元素,返回添加完元素的节点
     */
    private Node add(Node node, K k, V v) {
        if(node == null) {
            size ++;
            node = new Node(k, v);
        }
        if(k.compareTo(node.key) < 0) {
            node.left = add(node.left, k, v);
        } else if(k.compareTo(node.key) > 0) {
            node.right = add(node.right, k, v);
        } else {
            node.value = v;
        }
        return node;
    }

    public Node getMin(K k) {
        return getMin(root, k);
    }

    private Node getMin(Node node, K k) {
        if(node == null) {
            return null;
        }
        while(node != null) {
            if(node.left.key.equals(k)) {
                return node.left;
            }
            node = node.left;
        }
        return null;
    }

    @Override
    public V remove(K k) {
        Node node = getNode(k);
        if(node == null) {
            return null;
        } else {
            root = remove(root, k);
        }
        return node.value;
    }

    private Node remove(Node node, K k) {
        if(node == null) {
            return null;
        }
        if(k.compareTo(node.key) < 0) {
            node.left = remove(node.left, k);
            return node;
        } else if(k.compareTo(node.key) > 0) {
            node.right = remove(node.right, k);
            return node;
        } else {
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            Node successor = minum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    /**
     * 查找以node为根节点的二叉树的最小节点
     */
    private Node minum(Node node) {
        if(node.left == null) {
            return node;
        }
        return minum(node.left);
    }

    /**
     * 删除以node为根节点的最小节点
     */
    private Node removeMin(Node node) {
        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
        if(node == null) {
            throw new IllegalArgumentException(k + " doesn`t exist!");
        }
        node.value = v;
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
        return false;
    }
}

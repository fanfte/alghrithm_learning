package com.fanfte.algorithm.tree;

/**
 * Created by tianen on 2018/11/13
 *
 * @author fanfte
 * @date 2018/11/13
 **/
public class BST<E extends Comparable<E>> {

    public class Node {
        private E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;

    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void add(E e) {
//        if(root == null) {
//            root = new Node(e);
//            size ++;
//        } else {
//            add(root, e);
//        }
        root = add2(root, e);
    }

    private void add(Node node, E e) {
        if(e.equals(node.e)) {
            return;
        } else if(e.compareTo(node.e) < 0 && null == node.left) {
            node.left = new Node(e);
            size ++;
            return;
        } else if(e.compareTo(node.e) > 0 && null == node.right ) {
            node.right = new Node(e);
            size ++;
            return;
        }
        if(e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    /**
     * improved add method
     * @param node 被添加的节点
     * @param e 元素
     * @return 一次操作添加完成后的根节点
     */
    private Node add2(Node node, E e) {
        if(null == node) {
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0) {
            node.left = add2(node.left, e);
        } else {
            node.right = add2(node.right, e);
        }
        return node;
    }

    /**
     * 是否存在二分搜索树中
     * @param e 元素
     * @return boolean
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 查找以node为根节点的子树中是否有元素e
     * @param node 根节点node
     * @param e 元素
     * @return boolean
     */
    public boolean contains(Node node, E e) {
        if(null == node) {
            return false;
        }
        boolean result = false;
        if(e.compareTo(node.e) == 0) {
            return true;
        } else if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) {
            return ;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if(node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    public String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < depth; i ++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        bst.add(2);
        bst.add(1);
        bst.add(3);

        System.out.println(bst.contains(3));

        System.out.println(bst);
    }
}

package com.fanfte.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && null == node.left) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && null == node.right) {
            node.right = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    /**
     * improved add method
     *
     * @param node 被添加的节点
     * @param e    元素
     * @return 一次操作添加完成后的根节点
     */
    private Node add2(Node node, E e) {
        if (null == node) {
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add2(node.left, e);
        } else {
            node.right = add2(node.right, e);
        }
        return node;
    }

    /**
     * 是否存在二分搜索树中
     *
     * @param e 元素
     * @return boolean
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 查找以node为根节点的子树中是否有元素e
     *
     * @param node 根节点node
     * @param e    元素
     * @return boolean
     */
    public boolean contains(Node node, E e) {
        if (null == node) {
            return false;
        }
        boolean result = false;
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    public String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.e + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.e + " ");
        inOrder(node.right);
    }

    private void afterOrder() {
        afterOrder(root);
    }

    private void afterOrder(Node node) {

        if (node == null) {
            return;
        }
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.print(node.e + " ");
    }

    public void preOrderNoRC() {
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node top = s.pop();
            System.out.print(top.e + " ");
            if (top.right != null) {
                s.push(top.right);
            }
            if (top.left != null) {
                s.push(top.left);
            }
        }
    }

    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.print(node.e + " ");
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    public Node getMin() {
        return minum(root);
    }

    private Node minum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minum(node.left);
    }

    public Node getMax() {
        return max(root);
    }

    private Node max(Node node) {

        if(node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public Node removeMinNode() {
        root = removeMin(root);
        return getMin();
    }

    /**
     * 删除以node为根节点的最小节点
     * @param node 根节点
     * @return 删除最小节点之后的树的根节点
     */
    private Node removeMin(Node node) {
        if(node.left == null) {
            // 如果有右子树，则保存右子树
            // 没有右子树，即node为叶子节点，则node.right为null,返回null
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node);
        return node;
    }

    private Node removeMax() {
        Node max = getMax();
        root = removeMax(root);
        return max;
    }

    /**
     * 以node为根节点的子树删除最大节点
     * @param node 根节点为node
     * @return 删除最大节点后的树的根节点
     */
    private Node removeMax(Node node) {

        if(node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void removeNode(E e) {
        root = removeNode(root, e);
    }

    private Node removeNode(Node node, E e) {
        if(node == null) {
            return null;
        }
        if(e.compareTo(node.e) < 0) {
            node.left = removeNode(node.left, e);
            return node;
        } else if(e.compareTo(node.e) > 0) {
            node.right = removeNode(node.right, e);
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

            Node successor = new Node(minum(node.right).e);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    public void removeNode2(E e) {
        root = removeNode2(root, e);
    }

    /**
     * 从以node为根的树中移除e元素
     * @param node
     * @param e
     * @return
     */
    private Node removeNode2(Node node, E e) {
        if(node == null) {
            return null;
        }
        if(e.compareTo(node.e) < 0) {
            node.left = removeNode2(node.left, e);
            return node;
        } else if(e.compareTo(node.e) > 0) {
            node.right = removeNode2(node.right, e);
            return node;
        } else {
            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                return leftNode;
            } else if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                return rightNode;
            } else {
                Node successor = new Node(minum(node.right).e);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        bst.add(2);
        bst.add(1);
        bst.add(3);
        bst.add(4);
        bst.add(5);
        bst.add(6);
        bst.add(7);
        bst.add(8);

        System.out.println(bst.contains(3));
        bst.preOrder();
        System.out.println();
        bst.preOrderNoRC();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.afterOrder();
        System.out.println();
//        System.out.println(bst);
        bst.levelOrder();
        System.out.println();
        System.out.println(bst.getMin().e);
        System.out.println(bst.getMax().e);
        bst.removeMax();
        bst.levelOrder();
        System.out.println();
        bst.removeNode2(3);
        bst.levelOrder();

    }
}

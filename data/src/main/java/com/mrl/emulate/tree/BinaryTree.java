package com.mrl.emulate.tree;

/**
 * @author liucun
 * @Description: 普通二叉树
 * @date 2018/6/2520:26
 * <p>
 * 案例地址  https://blog.csdn.net/fengrunche/article/details/52305748
 */
public class BinaryTree<T> {

    /**
     * 根节点
     */
    private Node<T> root = null;


    public BinaryTree(T data) {
        this.root = new Node<>(data);
        root.left = null;
        root.right = null;
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (root == null) {
            root = node;
            root.left = null;
            root.right = null;
        } else {
            Node<T> current = root;
            Node<T> parent = null;
            while (true) {
                //这里直接用hashCode 做比较
                if (data.hashCode() < node.data.hashCode()) {
                    parent = current;
                    current = current.left;
                    if (current != null) {
                        parent.left = current;
                    }
                } else if (data.hashCode() < node.data.hashCode()) {

                }
            }
        }
    }


    public int compare(Node<T> o) {
        if (o.hashCode() > root.hashCode()) {
            return 1;
        }
        if (o.hashCode() < root.hashCode()) {
            return -1;
        }
        return 0;
    }


    /**
     * 节点
     *
     * @param <Integer>
     */
    private class Node<T> {
        /**
         * 左子节点
         */
        private Node<T> left;
        /**
         * 右子节点
         */
        private Node<T> right;
        /**
         * 数据
         */
        private T data;


        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}

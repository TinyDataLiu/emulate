package com.mrl.emulate.tree;

/**
 * @author liucun
 * @Description: 普通二叉树
 * @date 2018/6/2520:26
 * <p>
 * 案例地址  https://blog.csdn.net/fengrunche/article/details/52305748
 */
public class IntBinaryTree {


    private Node root = null;


    public IntBinaryTree(Integer value) {
        this.root = new Node(value);
        root.left = null;
        root.right = null;
    }


    /**
     * 插入值
     *
     * @param value
     */
    public void add(Integer value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            root.left = null;
            root.right = null;
        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                if (value < current.data) {
                    parent = current; // 将root 设置成父节点
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        System.out.println(String.format("%s 插入LEFT", node.data) + "---->" + "PARENT=" + parent);
                        break;
                    }
                } else if (value > current.data) {
                    parent = current;
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        System.out.println(String.format("%s 插入RIGHT", node.data) + "---->" + "PARENT=" + parent);
                        break;
                    }
                } else {
                    throw new RuntimeException("add failed, the same value .");
                }
            }
        }
    }

    /**
     * 节点类
     */
    class Node {
        private Integer data;
        private Node left;
        private Node right;

        public Node(Integer value) {
            data = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "IntBinaryTree{" +
                "root=" + root +
                '}';
    }


    public static void main(String[] args) {
        IntBinaryTree tree = new IntBinaryTree(0);
        tree.add(-1);
        tree.add(-2);
        tree.add(-3);
        tree.add(-4);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(11);
        tree.add(12);
        System.out.println(tree);
    }
}

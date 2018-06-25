package com.mrl.emulate.list;

/**
 * @author liucun
 * @date 2018/6/2513:54
 * 链表的实现
 */
public class MyLinkedList<E> {


    /**
     * 链表的单个存储单元
     *
     * @param <E>
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> head; // 维护头结点
    private Node<E> tail; // 维护尾节点

    /**
     * 插入
     *
     * @param ele
     */
    public void add(E ele) {
        Node<E> node = new Node<E>(null, ele, null);
        if (head == null) {
            head = tail = node;
        } else {
            //默认尾部添加节点
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }


}

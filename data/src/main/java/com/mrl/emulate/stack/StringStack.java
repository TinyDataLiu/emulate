package com.mrl.emulate.stack;

/**
 * @author liucun
 * @Description: 数据结构-栈
 * 特点：后进先出
 * 按照生活中常见的场景形容一下栈，
 * 就是堆盘子，你第一个放下的盘子一定是在底部（在栈中的就叫push（压入）），
 * 最后一个盘子在顶部，当你想用盘子的时候，一定是从顶部拿起（在栈中就叫做pop（弹出））
 * @date 2018/6/2513:31
 */
public class StringStack {
    private int indexTop = -1;
    private int maxSize;

    private String[] box;  //容器

    public StringStack(int maxSize) {
        this.maxSize = maxSize;
        this.box = new String[maxSize];
    }

    public void push(String ch) {
        box[++indexTop] = ch;
    }

    public String pop() {
        return box[indexTop--];
    }

    public boolean isEmpty() {
        return indexTop == -1 ? true : false;
    }
}

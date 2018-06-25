package com.mrl.emulate.stack;

/**
 * @author liucun
 * @Description: 根据栈的特性实现字符串反转
 * @date 2018/6/2513:41
 * 1.栈和队列的共同特点是什么？
 * 答：只允许在端点处插入或删除元素
 * 2.栈通常采用的两种存储结构是什么？
 * 答：线性存储结构和连表
 * <p>
 * 3.下列关于栈的叙述正确的是（D）
 * A. 栈是非线性结构
 * B. 栈是一种树状结构
 * C. 栈具有先进先出的特征
 * D. 栈有后进先出的特征
 * <p>
 * 4. 链表不具有的特点是（B）
 * A. 不必事先估计存储空间
 * B. 可随机访问任一元素
 * C. 插入删除不需要移动元素
 * D. 所需空间与线性表长度成正比
 * <p>
 * 5. 用链表表示线性表的优点是什么？
 * 答案：便于插入和删除操作。
 */
public class StackTest {

    public static void main(String[] args) {
        String name = "liuchun";
        StringStack stringStack = new StringStack(name.length());
        for (int i = 0; i < name.length(); i++) {
            stringStack.push(name.charAt(i) + "");
        }
        String reverse = "";
        for (int i = 0; i < name.length(); i++) {
            reverse += stringStack.pop();
        }
        System.out.println(reverse);
    }
}

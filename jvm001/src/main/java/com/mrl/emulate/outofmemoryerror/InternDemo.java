package com.mrl.emulate.outofmemoryerror;

/**
 * @author liuchun
 * @date 2018/9/10 10:15
 */
public class InternDemo {
    public static void main(String[] args) {

        //是首次出现
        String ss1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(ss1.intern() == ss1);

        //不是首次出现。   这所谓的 首次 是对应 StringBuilder.toString() 方法 是不是首次， 如果是首次， 则 会返回 true  / 不是返回false  jdk1.7
        String ss2 = new StringBuilder("ja").append("va").toString();
        System.out.println(ss2.intern() == ss2);
    }
}

package com.mrl.emulate.algorithm;

/**
 * @author liucun
 * @Description: Fibonacci sequence 斐波那契数列问题，经典的兔子问题
 * @date 2018/6/1910:25
 */
public class FibonacciSequence {

    /**
     * 递归方式解决兔子数的问题
     *
     * @param monthCount 月数
     * @return 兔子总数
     */
    public static int getRabbitNum(int monthCount) {
        if (monthCount == 1 || monthCount == 2) {
            //第一个月和第二个月属于特殊情况
            return 1;
        } else {
            //三个月以后， 返回上个月的兔子数 + 大上个月的兔子数
            return getRabbitNum(monthCount - 1) + getRabbitNum(monthCount - 2);
        }
    }


    /**
     * for 循环的方式斐波那契数列数列问题
     *
     * @param monthCount
     * @return
     */
    public static int getRabbitNumFor(int monthCount) {
        //兔子总数，初始值为1
        int count = 1;
        //上个月的兔子数
        int prev = 0;
        //大上个月的兔子数
        int last = 0;
        for (int i = 1; i <= monthCount; i++) {
            // 当前月份的兔子数
            int now = prev + last;
            // 打印本月兔子数
            if (i == 3) {
                //第三个月开始新增一对兔子
                now = 1;
            }
            //设定上个月为本月
            last = prev;
            // 设定打上个月为上个月
            prev = now;
            // 当前月份的兔子数
            count += now;
        }
        return count;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getRabbitNum(10));
        System.out.println(getRabbitNumFor(10));
    }

}

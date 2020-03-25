package com.alice.dubbo.provider.dubbo03provider;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 数组统计问题
 */
public class ArrayTest {
    public static void main(String[] args) {
//    1.数组初始化
        int arr[] = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(99999);
        }
//    2.排序
        Arrays.sort(arr);
//    3.查找出最大的数
        int max = arr[arr.length - 1];
//    4.查找出最小的数，
        int min = arr[0];
//    5.最大最小数之外的计算省略，因为都是0 所及不做统计

//        for (int i = 0; i <= max; i += 10) {
//            System.out.println(i - 1);
//        }

//     6.通过最小值计算从哪个区间开始，以及通过最大值计算到哪个区间结束
//     7.
    }
}

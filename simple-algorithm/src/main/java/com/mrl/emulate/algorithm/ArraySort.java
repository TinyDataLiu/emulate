package com.mrl.emulate.algorithm;

import java.util.Arrays;

/**
 * @author liucun
 * @Description: TODO 除了冒泡排序以外的几种经典排序算法需要补充
 * @date 2018/6/1910:51
 */
public class ArraySort {


    /**
     * 需要排序的数组
     */
    static int[] arrs = {1, 2, 4, 6, 3, 8, 9, 12, 22, 55, 90, 11, 23};


    /**
     * 冒泡法
     *
     * @param arr 需要进行排序的数组
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        //用于存储临时变量
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                /*判断大小并开始做交换处理*/
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(arrs)));
    }

}

package com.mrl.emulate;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class SortTest {

    int[] arr = {9, 8, 7, 6, 5, 8, 10, 55, 88, 45, 32};

    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    public int[] bubbleSort(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 从小到大排序， 把大的往后放
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    @Test
    public void bubbleSortTest() {
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}

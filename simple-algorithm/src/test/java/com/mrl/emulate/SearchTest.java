package com.mrl.emulate;

import org.junit.Test;

/**
 * @author liucun
 * @Description: ${todo}
 * @date 2018/6/2519:27
 */
public class SearchTest {

    int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] == key) {
                return mid;
            }
            /*查询前半部分*/
            if (arr[mid] > key) {
                high = mid - 1;
            }
            /*查询后半部分*/
            if (arr[mid] < key) {
                low = mid + 1;
            }
        }
        return -1;
    }


    public int binarySearch2(int[] arr, int key, int low, int high) {
        int mid = (low + high) >>> 1;
        if (arr[mid] == key) {
            return mid;
        }
        /**
         * 这里我比较容易乱，所以写了注释
         */
        if (arr[mid] > key) {
            /*查前半部分*/
            return binarySearch2(arr, key, low, mid - 1);
        }
        if (arr[mid] < key) {
            /*查后半部分*/
            return binarySearch2(arr, key, mid + 1, high);
        }
        return -1;
    }

    @Test
    public void binarySearch() {
        System.out.println(binarySearch(arr, 11));
        System.out.println(binarySearch2(arr, 11, 0, arr.length - 1));
    }

}

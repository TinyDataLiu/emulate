package com.mrl.emulate.sort;

/**
 * @author liucun
 * @Description: 二分查找简单实现
 * @date 2018/6/2517:23
 */
public class BinarySearch {

    static int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};

    /**
     * @param arr
     * @param searchKey
     * @return
     */
    public static int binarySearch(int arr[], int searchKey) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;  // 防止溢出
            if (arr[mid] == searchKey) {
                return mid;
            }
            if (arr[mid] > searchKey) {
                System.out.println(String.format("mid = %s  > searchKey %s 说明在前半部分 高位-", mid, searchKey));
                high = mid - 1;
            }
            if (arr[mid] < searchKey) {
                System.out.println(String.format("mid = %s  < searchKey %s 说明在后半部分 低位+", mid, searchKey));
                low = mid + 1;
            }
        }
        return -1;
    }


    public static int binarySearch2(int arr[], int searchKey, int low, int high) {
        int mid = (low + high) >>> 1;
        if (arr[mid] == searchKey) {
            return mid;
        }

        if (arr[mid] > searchKey) {
            System.out.println(String.format("查询前半部分"));
            return binarySearch2(arr, searchKey, low, mid - 1);
        }

        if (arr[mid] < searchKey) {
            System.out.println("查询后半部分");
            return binarySearch2(arr, searchKey, mid + 1, high);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(arr, 15));
        System.out.println(binarySearch2(arr, 7, 0, arr.length - 1));
    }
}

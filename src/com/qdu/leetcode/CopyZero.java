package com.qdu.leetcode;


import java.util.Arrays;

/**
 * @author chengchuanxin chengchuanxin@23mofang.com
 * @since 2019-06-16
 */
public class CopyZero {
    public static void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && i + 1 < arr.length) {
                int temp = 0;
                for (int j = i + 1; j < arr.length; j++) {
                    int innerTemp = arr[j];
                    arr[j] = temp;
                    temp = innerTemp;
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}

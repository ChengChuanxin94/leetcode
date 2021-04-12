package com.qdu.leetcode;
import java.util.Arrays;

/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/19
 */
public class MergeTwoSortArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] array = new int[m + n];
        int j = 0;
        int k = 0;
        int current;
        for (int i = 0; i < m + n; i++) {
            if (j < m && k < n) {
                if (nums1[j] > nums2[k]) {
                    current = nums2[k];
                    k++;
                } else {
                    current = nums1[j];
                    j++;
                }
            } else if (j < m) {
                current = nums1[j];
                j++;
            } else {
                current = nums2[k];
                k++;
            }
            array[i] = current;
        }
        System.arraycopy(array, 0, nums1, 0, array.length);
    }
}

package com.qdu.leetcode;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/27
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {4, 1, 2, 1, 2}));
    }

    public static int singleNumber(int[] nums) {
        int target = nums[0];
        for (int i = 1; i < nums.length; i++) {
            target ^= nums[i];
        }
        return target;
    }
}

package com.qdu.leetcode;

/**
 * @author chengchuanxin chengchuanxin@23mofang.com
 * @since 2019/10/15
 */
public class RemoveArrayElements {
    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int leftCount = removeElement(nums, 2);
        for (int i = 0; i < leftCount; i++) {
            System.out.println(nums[i]);
        }
    }
}

package com.qdu.leetcode;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/29
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] ints = new TwoSum1().twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int d;
        Integer index;
        for (int i = 0; i < nums.length; i++) {
            d = target - nums[i];
            index = map.get(d);
            if (index != null && index != i) {
                return new int[] {i, index};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}

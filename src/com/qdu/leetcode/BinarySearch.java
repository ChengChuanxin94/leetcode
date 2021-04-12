package com.qdu.leetcode;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/9/24
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = {1,3,5,6};
        System.out.println(searchInsert(ints, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low] >= target ? low : low + 1;
    }
}

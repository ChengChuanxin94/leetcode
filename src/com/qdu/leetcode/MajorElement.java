package com.qdu.leetcode;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/29
 */
public class MajorElement {
    public static void main(String[] args) {
        System.out.println(new MajorElement().majorElementByDivideAndConquer(new int[] {2, 2, 1, 1, 1, 2, 2}));
    }

    public int majorElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int targetCount = nums.length / 2;
        if (nums.length == 1) {
            return nums[0];
        }
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                count++;
                if (count > targetCount) {
                    return num;
                }
                map.put(num, count);
            }
        }
        throw new RuntimeException("not found");
    }

    public int majorElementBySort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 分治法
     *
     * @param nums
     * @return
     */
    public int majorElementByDivideAndConquer(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    public int divideAndConquer(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = (end-start) / 2 + start;
        int leftMajor = divideAndConquer(nums, start, mid);
        int rightMajor = divideAndConquer(nums, mid + 1, end);
        if (leftMajor == rightMajor) {
            return leftMajor;
        } else {
            int leftCount = getCount(nums, leftMajor, start, end);
            int rightCount = getCount(nums, rightMajor, start, end);
            return leftCount > rightCount ? leftMajor : rightMajor;
        }

    }

    public int getCount(int[] nums, int target, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
}

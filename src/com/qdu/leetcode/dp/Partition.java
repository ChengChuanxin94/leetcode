package com.qdu.leetcode.dp;
/**
 * @author chengchuanxin chengchuanxin94@163.com
 * @since 2021/3/29
 */
public class Partition {
    public static void main(String[] args) {
        System.out.println(new Partition().canPartition(new int[] {14, 9, 8, 4, 3, 2}));
    }

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        int[][] dp = new int[half + 1][nums.length + 1];
        for (int i = 1; i <= half; i++) {
            for (int j = 1; j <= nums.length; j++) {
                if (nums[j - 1] <= i) {
                    dp[i][j] = Math.max(dp[i - nums[j - 1]][j - 1] + nums[j - 1], dp[i][j-1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
                if (dp[i][j] == half) {
                    return true;
                }
            }
        }
        return false;
    }
}

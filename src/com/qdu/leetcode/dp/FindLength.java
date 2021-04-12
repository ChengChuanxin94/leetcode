package com.qdu.leetcode.dp;
/**
 * @author chengchuanxin chengchuanxin94@163.com
 * @since 2021/3/7
 */
public class FindLength {
    public static void main(String[] args) {
        System.out.println(new FindLength().findLength(new int[] {1, 0, 0, 0, 1}, new int[] {1, 0, 0, 1, 1}));
    }

    public int findLength(int[] A, int[] B) {
        int lengthA = A.length;
        int lengthB = B.length;
        int[][] dp = new int[lengthA][lengthB];
        int max = 0;
        for (int i = 0; i < lengthA; i++) {
            for (int j = 0; j < lengthB; j++) {
                if (A[i] == B[j]) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}

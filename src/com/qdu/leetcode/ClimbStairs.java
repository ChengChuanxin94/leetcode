package com.qdu.leetcode;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/16
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(20));
    }

    public static int climbStairs(int n) {
        int j = 0;
        int k = 0;
        int temp;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                j = i;
            } else if (i == 2) {
                k = i;
            } else {
                temp = k;
                k = k + j;
                j = temp;
            }
        }

        return k;
    }
}

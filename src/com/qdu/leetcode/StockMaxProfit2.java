package com.qdu.leetcode;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/27
 */
public class StockMaxProfit2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        int sumProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sumProfit += prices[i] - prices[i - 1];
            }
        }
        return sumProfit;
    }
}

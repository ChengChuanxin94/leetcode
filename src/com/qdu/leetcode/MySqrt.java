package com.qdu.leetcode;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/16
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(123456789));
    }

    public static int mySqrt(int x) {
        int low = 0;
        int high = x;
        int mid;
        long result;
        while (low <= high) {
            mid = (high - low) / 2 + low;
            result = (long)mid * (long)mid;
            if ( result==x){
                return mid;
            } else if (result > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }
}

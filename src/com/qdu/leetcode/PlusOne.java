package com.qdu.leetcode;
import java.util.Arrays;

/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/14
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[] {0})));
    }

    public static int[] plusOne(int[] digits) {
        int carry = 0;
        int result;
        for (int i = digits.length - 1; i >= 0; i--) {
            result = digits[i] + carry;
            if (i == digits.length - 1) {
                result++;
            }
            if (result == 10) {
                carry = 1;
                result = 0;
            } else {
                carry = 0;
            }
            digits[i] = result;
        }
        if (carry == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
        return digits;
    }
}

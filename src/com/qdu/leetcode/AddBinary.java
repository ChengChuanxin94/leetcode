package com.qdu.leetcode;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/15
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
            "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
        //System.out.println(addBinaryByConvert("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", 
        // "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    public static String addBinary(String a, String b) {
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        int length = Math.max(arrayA.length, arrayB.length);
        char[] sum = new char[length];

        int i = arrayA.length - 1;
        int j = arrayB.length - 1;
        char m;
        char n;
        char zero = '0';
        char one = '1';
        char c = zero;
        char result = zero;
        for (int k = 0; i - k >= 0 || j - k >= 0; k++) {
            m = i - k < 0 ? zero : arrayA[i - k];
            n = j - k < 0 ? zero : arrayB[j - k];
            if (m == one && n == one) {
                result = c;
                c = one;
            }
            if ((m == one && n == zero) || (m == zero && n == one)) {
                if (c == one) {
                    result = zero;
                } else {
                    result = one;
                }
            }
            if (m == zero && n == zero) {
                result = c;
                c = zero;
            }
            sum[length - k - 1] = result;
        }
        if (c == one) {
            char[] newSum = new char[length + 1];
            newSum[0] = c;
            System.arraycopy(sum, 0, newSum, 1, sum.length);
            return new String(newSum);
        }
        return new String(sum);
    }
}

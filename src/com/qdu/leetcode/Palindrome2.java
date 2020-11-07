package com.qdu.leetcode;

import java.util.Random;

/**
 * @author chengchuanxin chengchuanxin@23mofang.com
 * @since 2019/10/7
 */
public class Palindrome2 {
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(1000);
            System.out.println(num + "is palindrome: " + isPalindrome(num));
        }
    }
}

package com.qdu.leetcode;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/27
 */
public class Palindrome1 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().trim().toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (!validChar(chars[i])) {
                i++;
                continue;
            }
            if (!validChar(chars[j])) {
                j--;
                continue;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean validChar(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }


}

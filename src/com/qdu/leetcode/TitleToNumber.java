package com.qdu.leetcode;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/30
 */
public class TitleToNumber {
    public static void main(String[] args) {
        System.out.println(new TitleToNumber().titleToNumber("AZ"));
    }

    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}

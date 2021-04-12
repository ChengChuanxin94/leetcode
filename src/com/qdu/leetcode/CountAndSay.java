package com.qdu.leetcode;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/9/24
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String s = countAndSay(n - 1);
            StringBuilder stringBuilder = new StringBuilder();
            int count = 1;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i + 1 < chars.length && chars[i + 1] == chars[i]) {
                    count++;
                } else {
                    stringBuilder.append(count).append(chars[i]);
                    count = 1;
                }
            }
            return stringBuilder.toString();
        }
    }
}

package com.qdu.leetcode;

/**
 * @author chengchuanxin chengchuanxin@23mofang.com
 * @since 2019/10/9
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int currentLength = strs[i].length();
            if (currentLength < minLength) {
                minLength = currentLength;
            }
        }

        for (int i = 0; i < minLength; i++) {
            char currentCommonChar = strs[0].charAt(i);
            for (String str : strs) {
                char c = str.charAt(i);
                if (c != currentCommonChar) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLength);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}

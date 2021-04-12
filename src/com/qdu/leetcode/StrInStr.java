package com.qdu.leetcode;

/**
 * @author chengchuanxin chengchuanxin@23mofang.com
 * @since 2019/10/21
 */
public class StrInStr {

    public static int strInStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return 0;
        }
        int needleLength = needle.length();
        int haystackLength = haystack.length();

        if (needleLength > haystackLength) {
            return -1;
        } else if (needleLength == 0) {
            return 0;
        }
        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();
        for (int i = 0; i < haystackLength; i++) {
            if (haystackCharArray[i] == needleCharArray[0]) {
            }
        }
        return 0;


    }

    public static void main(String[] args) {
        System.out.println(strInStr("aaaaa", "bda"));
    }
}

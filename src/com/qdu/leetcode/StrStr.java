package com.qdu.leetcode;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/9/23
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        if (needleArray.length > haystackArray.length) {
            return -1;
        }
        for (int i = 0; i <= haystackArray.length - needle.length(); i++) {
            boolean cis = false;
            int i1 = 0;
            while (i1 < needleArray.length) {
                if (haystackArray[i + i1] == needleArray[i1]) {
                    cis = true;
                    i1++;
                } else {
                    cis = false;
                    break;
                }

            }
            if (cis && i1 == needleArray.length) {
                return i;
            }
        }
        return -1;
    }
}

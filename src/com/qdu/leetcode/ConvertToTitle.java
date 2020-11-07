package com.qdu.leetcode;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/29
 */
public class ConvertToTitle {
    public static void main(String[] args) {
        System.out.println(new ConvertToTitle().convertToTitle(260));
    }

    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        if (n <= 26) {
            return new String(new char[] {(char) ('A' + n - 1)});
        } else {
            int i = n / 26;
            int c = n - 26 * i;
            if (c == 0) {
                return convertToTitle(i - 1) + 'Z';
            } else {
                return convertToTitle(i) + convertToTitle(c);
            }
        }
    }
}

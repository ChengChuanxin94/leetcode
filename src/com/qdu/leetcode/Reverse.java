package com.qdu.leetcode;

import java.util.Random;

/**
 * @author chengchuanxin chengchuanxin@23mofang.com
 * @since 2019/10/7
 */
public class Reverse {
    public static int reverseNum(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        char[] temp = new char[chars.length];
        if (!s.startsWith("-")) {
            for (int i = chars.length - 1, j = 0; i >= 0; i--, j++) {
                temp[j] = chars[i];
            }
        } else {
            temp[0] = '-';
            for (int i = chars.length - 1, j = 1; i > 0; i--, j++) {
                temp[j] = chars[i];
            }
        }
        int reverse;
        try {
            reverse = Integer.parseInt(String.valueOf(temp));
        } catch (NumberFormatException e) {
            return 0;
        }
        return reverse;
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int origin = random.nextInt(1000);
            if (i % 2 == 0) {
                origin *= -1;
            }
            System.out.println("origin: " + origin + "reverse: " + reverseNum(origin));
        }
        System.out.println(reverseNum(Integer.MIN_VALUE));
    }
}

package com.qdu.leetcode;

import java.util.HashMap;

/**
 * @author chengchuanxin chengchuanxin@23mofang.com
 * @since 2019/10/8
 */
public class RomanToInt {
    public static final HashMap<Character, Integer> ROMAN_INT_MAP = new HashMap<>();

    static {
        ROMAN_INT_MAP.put('I', 1);
        ROMAN_INT_MAP.put('V', 5);
        ROMAN_INT_MAP.put('X', 10);
        ROMAN_INT_MAP.put('L', 50);
        ROMAN_INT_MAP.put('C', 100);
        ROMAN_INT_MAP.put('D', 500);
        ROMAN_INT_MAP.put('M', 1000);
    }


    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            int next = 0;
            if (i + 1 < chars.length) {
                next = ROMAN_INT_MAP.get(chars[i + 1]);
            }
            int current = ROMAN_INT_MAP.get(chars[i]);
            if (current < next) {
                result += next - current;
                i++;
            } else {
                result += current;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}

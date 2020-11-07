package com.qdu.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author chengchuanxin chengchuanxin@23mofang.com
 * @since 2019/10/10
 */
public class BracketsValid {
    private static final HashMap<Character, Character> BRACKET_MAP = new HashMap<>();

    static {
        BRACKET_MAP.put('(', ')');
        BRACKET_MAP.put('{', '}');
        BRACKET_MAP.put('[', ']');
    }

    public static boolean bracketsValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else {
                Character bracket = BRACKET_MAP.get(stack.peek());
                if (bracket != null && bracket == chars[i]) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(bracketsValid("()"));
        System.out.println(bracketsValid("()[]{}"));
        System.out.println(bracketsValid("(]"));
        System.out.println(bracketsValid("([)]"));
        System.out.println(bracketsValid("{[]}"));
        System.out.println(bracketsValid("){"));
        System.out.println(bracketsValid("([)"));
    }
}

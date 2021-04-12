package com.qdu.leetcode.greedy;
import java.util.ArrayDeque;

/**
 * @author chengchuanxin chengchuanxin94@163.com
 * @since 2021/3/7
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("bbcaac"));
    }

    public String removeDuplicateLetters(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int[] charCount = new int[26];
        boolean[] booleans = new boolean[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            charCount[aChar - 'a'] += 1;
        }
        for (char aChar : chars) {
            charCount[aChar - 'a'] -= 1;
            if (booleans[aChar - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && aChar < stack.peek() && charCount[stack.peek() - 'a'] >= 1) {
                booleans[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(aChar);
            booleans[aChar - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

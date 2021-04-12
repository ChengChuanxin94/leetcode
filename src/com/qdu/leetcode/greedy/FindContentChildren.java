package com.qdu.leetcode.greedy;
import java.util.Arrays;

/**
 * @author chengchuanxin chengchuanxin94@163.com
 * @since 2021/3/7
 */
public class FindContentChildren {
    public static void main(String[] args) {
        System.out.println(new FindContentChildren().findContentChildren(new int[] {1, 2, 3}, new int[] {1, 2, 2}));
    }

    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int childCount = g.length;
        int cakeCount = s.length;
        int i = 0;
        int j = 0;
        while (i < childCount && j < cakeCount) {
            if (s[j] >= g[i]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }
        return count;
    }
}

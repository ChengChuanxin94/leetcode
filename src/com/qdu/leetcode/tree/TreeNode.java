package com.qdu.leetcode.tree;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/20
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(Integer[] array, int i) {
        if (i >= array.length) {
            return null;
        }
        if (array[i] == null) {
            return null;
        }
        TreeNode current = new TreeNode(array[i]);
        current.left = buildTree(array, 2 * i + 1);
        current.right = buildTree(array, 2 * i + 2);
        return current;
    }

    public static TreeNode buildTree(Integer[] array) {
        return buildTree(array, 0);
    }

}

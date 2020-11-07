package com.qdu.leetcode.tree;


/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/20
 */
public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}

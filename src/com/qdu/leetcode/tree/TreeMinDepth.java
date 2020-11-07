package com.qdu.leetcode.tree;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/21
 */
public class TreeMinDepth {

    public static void main(String[] args) {
        TreeMinDepth treeMinDepth = new TreeMinDepth();
        TreeNode tree = TreeNode.buildTree(new Integer[] {2, null, 3, null, 4, null, 5, null, 6}, 0);
        System.out.println(treeMinDepth.minDepth(tree));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        int current = 1;
        if (leftDepth == 0) {
            current += rightDepth;
        } else if (rightDepth == 0) {
            current += leftDepth;
        } else {
            current += Math.min(leftDepth, rightDepth);
        }
        return current;
    }
}

package com.qdu.leetcode.tree;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/21
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] ints = {-10, -3, 0, 5, 9};
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode treeNode = sortedArrayToBST.sortedArrayToBST(ints);


    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int currentIndex = (end - start) / 2 + start;
        TreeNode currentNode = new TreeNode(nums[currentIndex]);
        currentNode.left = sortedArrayToBST(nums, start, currentIndex - 1);
        currentNode.right = sortedArrayToBST(nums, currentIndex + 1, end);
        return currentNode;
    }
}

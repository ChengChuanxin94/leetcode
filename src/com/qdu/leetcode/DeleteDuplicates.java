package com.qdu.leetcode;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/19
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 2, 2};
        ListNode head = null;
        ListNode pre = null;
        for (int i = 0; i < ints.length; i++) {
            ListNode listNode = new ListNode(ints[i]);
            if (pre == null) {
                head = listNode;
            } else {
                pre.next = listNode;
            }
            pre = listNode;
        }
        ListNode listNode = deleteDuplicates(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            if (pre != null && pre.val == current.val) {
                pre.next = current.next;
            } else {
                pre = current;
            }
            current = current.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode() {
        }
    }
}

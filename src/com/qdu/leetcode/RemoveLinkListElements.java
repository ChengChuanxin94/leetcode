package com.qdu.leetcode;

/**
 * @author chengchuanxin chengchuanxin@23mofang.com
 * @since 2019/10/16
 */
public class RemoveLinkListElements {

    public static ListNode removeLinkListElements(ListNode head, int val) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                if (pre == null) {
                    head = current.next;
                } else {
                    pre.next = current.next;
                }
            } else {
                pre = current;
            }
            current = current.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(1);
        listNode1.next.next = new ListNode(5);
        listNode1.next.next.next = new ListNode(7);
        ListNode listNode = removeLinkListElements(listNode1, 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

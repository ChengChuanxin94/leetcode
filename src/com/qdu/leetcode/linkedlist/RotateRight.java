package com.qdu.leetcode.linkedlist;
/**
 * @author chengchuanxin chengchuanxin94@163.com
 * @since 2021/2/7
 */
public class RotateRight {

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(new int[] {1}, -1);
        ListNode newHead = new RotateRight().rotateRight(head, 1);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        int modK = k % length;
        if (modK == 0) {
            return head;
        }
        //构造循环链表
        temp.next = head;
        int newTailIndex = length - modK - 1;

        for (int i = 0; i < newTailIndex; i++) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;


    }
}

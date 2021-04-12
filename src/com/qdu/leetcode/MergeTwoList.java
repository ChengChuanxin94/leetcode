package com.qdu.leetcode;

/**
 * @author chengchuanxin chengchuanxin@23mofang.com
 * @since 2019/10/10
 */
public class MergeTwoList {

    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (true) {
            if (l1 == null) {
                temp.next = l2;
                break;
            } else if (l2 == null) {
                temp.next = l1;
                break;
            }
            if (l1.val > l2.val) {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            } else {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }

        }
        return head.next;
    }

    /**
     * 链表Node
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1First = new ListNode(1);
        ListNode l1SecondNode = new ListNode(3);
        ListNode l1ThirdNode = new ListNode(5);
        l1First.next = l1SecondNode;
        l1SecondNode.next = l1ThirdNode;
        ListNode l2First = new ListNode(2);
        l2First.next = new ListNode(4);
        l2First.next.next = new ListNode(6);
        ListNode listNode = mergeTwoList(l1First, l2First);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}

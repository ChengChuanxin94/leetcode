package com.qdu.leetcode.linkedlist;
import java.awt.HeadlessException;

/**
 * @author chengchuanxin chengchuanxin94@163.com
 * @since 2021/4/5
 */
public class SortList {
    public static void main(String[] args) {
        // ListNode l1 = ListNode.buildListNode(new int[] {1, 2, 4});
        // ListNode l2 = ListNode.buildListNode(new int[] {1, 3, 4});
        // ListNode listNode = new SortList().mergeList(l1, l2);
        // System.out.println(ListNode.print(listNode));

        ListNode l3 = ListNode.buildListNode(new int[] {4, 2, 1, 3});
        ListNode sortList = new SortList().sortList(l3);
        System.out.println(ListNode.print(sortList));
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head == tail) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

        }
        ListNode mid = slow;
        ListNode midNex = mid.next;
        mid.next = null;
        ListNode l1 = sortList(head, mid);
        ListNode l2 = sortList(midNex, null);
        return mergeList(l1, l2);

    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        if (l1.val > l2.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return head;
    }
}

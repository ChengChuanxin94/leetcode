package com.qdu.leetcode.linkedlist;
import java.util.ArrayList;

/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/27
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode buildListNode(int[] array, int cycleIndex) {
        ListNode head = new ListNode(array[0]);
        ListNode pre = head;
        ArrayList<ListNode> listNodes = new ArrayList<>();
        listNodes.add(head);
        for (int i = 1; i < array.length; i++) {
            ListNode listNode = new ListNode(array[i]);
            pre.next = listNode;
            pre = listNode;
            listNodes.add(listNode);
        }
        if (cycleIndex >= 0) {
            listNodes.get(listNodes.size() - 1).next = listNodes.get(cycleIndex);
        }
        return head;
    }

    public void contact(ListNode node) {
        ListNode temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
}

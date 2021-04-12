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
        if (array.length == 0) {
            return null;
        }
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

    public static ListNode buildListNode(int[] array) {
        return buildListNode(array, -1);

    }

    public static String print(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append("->");
            }
            head = head.next;
        }
        return sb.toString();
    }

    public void contact(ListNode node) {
        ListNode temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
}

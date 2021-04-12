package com.qdu.leetcode;

/**
 * @author chengchuanxin chengchuanxin@23mofang.com
 * @since 2019-06-13
 */
public class AddTwoNums {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return getNextNode(l1, l2, 0);
    }

    public static ListNode getNextNode(ListNode l1, ListNode l2, int carryBit) {
        if (l1 == null && l2 == null && carryBit == 0) {
            return null;
        }
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }
        int sum = l1.val + l2.val + carryBit;
        carryBit = sum / 10;
        ListNode listNode = new ListNode(sum % 10);
        listNode.next = getNextNode(l1.next, l2.next, carryBit);
        return listNode;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}

package com.qdu.leetcode.linkedlist;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/27
 */
public class Intersection {
    public static void main(String[] args) {
        ListNode commonList = ListNode.buildListNode(new int[] {8, 4, 5}, -1);
        ListNode listNodeA = ListNode.buildListNode(new int[] {4, 1}, -1);
        ListNode listNodeB = ListNode.buildListNode(new int[] {5, 0, 1}, -1);
        listNodeA.contact(commonList);
        listNodeB.contact(commonList);
        System.out.println(new Intersection().getIntersectionNode(listNodeA, listNodeB).val);

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            lengthA++;
            a = a.next;
        }
        while (b != null) {
            lengthB++;
            b = b.next;
        }
        ListNode longList;
        ListNode shortList;
        if (lengthA > lengthB) {
            longList = headA;
            shortList = headB;
        } else {
            longList = headB;
            shortList = headA;
        }
        int dValue = Math.abs(lengthA - lengthB);
        for (int i = 0; i < dValue; i++) {
            if (longList == null) {
                return null;
            } else {
                longList = longList.next;
            }
        }
        while (longList != null && shortList != null) {
            if (longList == shortList) {
                return longList;
            } else {
                longList = longList.next;
                shortList = shortList.next;
            }
        }
        return null;
    }
}

package com.qdu.leetcode.linkedlist;
/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/27
 */
public class CycleList {
    public static void main(String[] args) {
        ListNode listNode = ListNode.buildListNode(new int[] {3, 2, 0, -4}, 1);
        System.out.println(hasCycle(listNode));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            if (fast == slow) {
                return true;
            }
            fast = fast.next;
            if (fast == null) {
                break;
            }
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }
}

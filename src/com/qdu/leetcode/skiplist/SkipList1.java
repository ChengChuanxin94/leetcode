package com.qdu.leetcode.skiplist;

import java.util.Random;

/**
 * skip list by next array
 *
 * @author chengchuanxin chengchuanxin94@163.com
 * @since 2024/7/12
 */
public class SkipList1 {
    Node head;
    int levelCount;
    int length;
    static final double DEFAULT_UPGRADE_RATIO = 0.5d;
    static final Integer MAX_LEVEL_COUNT = 32;
    static final Random RANDOM = new Random();

    static class Node {
        int value;
        Node[] next;

        public Node(int value, int levelCount) {
            this.value = value;
            this.next = new Node[levelCount];
        }
    }

    public SkipList1() {
        this.head = new Node(Integer.MIN_VALUE, MAX_LEVEL_COUNT);
    }

    public boolean search(int target) {
        Node temp = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].value < target) {
                temp = temp.next[i];
            }
            if (temp.next[i] != null && temp.next[i].value == target) {
                return true;
            }
        }
        return false;

    }

    public void add(int num) {
        int currentLevelCount;
        if (length != 0) {
            if (levelCount < MAX_LEVEL_COUNT && RANDOM.nextDouble() > DEFAULT_UPGRADE_RATIO) {
                levelCount++;
                currentLevelCount = levelCount;
            } else {
                currentLevelCount = RANDOM.nextInt(levelCount) + 1;
            }
        } else {
            levelCount = 1;
            currentLevelCount = 1;
        }
        Node node = new Node(num, currentLevelCount);
        Node temp = head;
        for (int i = currentLevelCount - 1; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].value <= num) {
                temp = temp.next[i];
            }
            if (temp.next[i] == null || temp.next[i].value > num) {
                Node next = temp.next[i];
                temp.next[i] = node;
                node.next[i] = next;
            }

        }
        length++;

    }

    public boolean erase(int num) {
        boolean found = false;
        Node temp = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].value < num) {
                temp = temp.next[i];
            }
            if (temp.next[i] != null && temp.next[i].value == num) {
                found = true;
                Node next = temp.next[i].next[i];
                temp.next[i] = next;
            }
        }
        if (found) {
            length--;
        }
        return found;
    }

    public static void main(String[] args) {
        SkipList1 skipList1 = new SkipList1();
        skipList1.add(1);
        skipList1.add(2);
        skipList1.add(3);
        System.out.println(skipList1.search(0));
        skipList1.add(4);
        System.out.println(skipList1.search(1));
        System.out.println(skipList1.erase(0));
        System.out.println(skipList1.erase(1));
        System.out.println(skipList1.search(1));
    }
}

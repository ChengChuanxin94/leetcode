package com.qdu.leetcode.skiplist;

import java.util.Random;

/**
 * skip list by right and down pointer
 *
 * @author chengchuanxin chengchuanxin94@163.com
 * @since 2024/7/13
 */
public class SkipList2 {
    Node head;
    int levelCount;
    int length;
    static final double DEFAULT_UPGRADE_RATIO = 0.5d;
    static final Integer MAX_LEVEL_COUNT = 32;
    static final Random RANDOM = new Random();

    static class Node {
        int value;
        Node right;
        Node down;

        public Node(int value) {
            this.value = value;
        }
    }

    public SkipList2() {
        this.head = new Node(Integer.MIN_VALUE);
    }

    public boolean search(int target) {
        Node temp = head;
        while (temp != null) {
            while (temp.right != null && temp.right.value < target) {
                temp = temp.right;
            }
            if (temp.right != null && temp.right.value == target) {
                return true;
            }
            temp = temp.down;
        }
        return false;

    }

    public void add(int num) {
        int currentLevelCount;
        boolean upgradeLevel = false;
        if (length != 0) {
            if (levelCount < MAX_LEVEL_COUNT && RANDOM.nextDouble() > DEFAULT_UPGRADE_RATIO) {
                levelCount++;
                currentLevelCount = levelCount;
                upgradeLevel = true;
            } else {
                currentLevelCount = RANDOM.nextInt(levelCount) + 1;
            }
        } else {
            levelCount = 1;
            currentLevelCount = 1;
        }
        Node temp = head;
        Node tempUp = null;
        for (int i = levelCount; i > 0 && temp != null; i--) {
            Node node = new Node(num);
            if (upgradeLevel && i == currentLevelCount) {
                Node newHead = new Node(Integer.MIN_VALUE);
                newHead.down = head;
                head = newHead;
                head.right = node;
                tempUp = node;
            } else {
                while (temp.right != null && temp.right.value < num) {
                    temp = temp.right;
                }
                if (i <= currentLevelCount) {
                    node.right = temp.right;
                    temp.right = node;
                    if (tempUp != null) {
                        tempUp.down = node;
                    }
                    tempUp = node;
                }
                temp = temp.down;
            }
        }

        length++;

    }

    public boolean erase(int num) {
        boolean found = false;
        Node temp = head;
        while (temp != null) {
            while (temp.right != null && temp.right.value < num) {
                temp = temp.right;
            }
            if (temp.right != null && temp.right.value == num) {
                temp.right = temp.right.right;
                found = true;
            }
            temp = temp.down;
        }
        if (found) {
            length--;
        }
        return found;
    }

    public static void main(String[] args) {
        SkipList2 skipList2 = new SkipList2();
        skipList2.add(1);
        skipList2.add(2);
        skipList2.add(3);
        System.out.println(skipList2.search(0));
        skipList2.add(4);
        System.out.println(skipList2.search(1));
        System.out.println(skipList2.erase(0));
        System.out.println(skipList2.erase(1));
        System.out.println(skipList2.search(1));
    }
}

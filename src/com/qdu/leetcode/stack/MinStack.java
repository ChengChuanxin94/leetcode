package com.qdu.leetcode.stack;
import java.util.Stack;

/**
 * @author chengchuanxin chengchuanxin94@gmail.com
 * @since 2020/10/27
 */
public class MinStack {
    Stack<Integer> dataStack;
    Stack<Integer> minValueStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataStack = new Stack<>();
        minValueStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minValueStack.isEmpty() || x <= getMin()) {
            minValueStack.push(x);
        }

    }

    public void pop() {
        Integer pop = dataStack.pop();
        if (pop == getMin()) {
            minValueStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minValueStack.peek();

    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

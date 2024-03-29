package top.irvingsoft.leetcode.code155;

import java.util.Stack;

class MinStack {

    private final Stack<Integer> minStack;
    private final Stack<Integer> stack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public int getMin() {
        return this.minStack.peek();
    }

    public void pop() {
        if (this.top() == this.getMin()) {
            this.minStack.pop();
        }
        this.stack.pop();
    }

    public void push(int val) {
        this.stack.push(val);
        if (this.minStack.isEmpty() || this.getMin() >= val) {
            this.minStack.push(val);
        }
    }

    public int top() {
        return this.stack.peek();
    }

}

/**
 * 最小栈
 *
 * @author TimeChaser
 * @since 2021/11/14 20:24
 */
public class Solution {

}
package top.irvingsoft.foroffer.code9;

import java.util.Stack;

class CQueueNode {

    Node head;
    Node tail;

    public CQueueNode() {

    }

    public void appendTail(int value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            Node temp = new Node(value);
            tail.next = temp;
            tail = temp;
        }
    }

    public int deleteHead() {
        if (head == null) {
            return -1;
        }
        int del = head.val;
        head = head.next;
        return del;
    }

    private class Node {

        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }

    }

}

class CQueueTwoStack {

    private final Stack<Integer> popStack;
    private final Stack<Integer> pushStack;

    public CQueueTwoStack() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void appendTail(int value) {
        pushStack.push(value);
    }

    public int deleteHead() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            return -1;
        } else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

}

/**
 * 用两个栈实现队列
 *
 * @author TimeChaser
 * @since 2021/11/27 11:16
 */
public class Solution {

}

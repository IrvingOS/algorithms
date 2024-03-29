package top.irvingsoft.leetcode.code2;

import top.irvingsoft.structure.ListNode;

/**
 * 两数相加
 *
 * @author TimeChaser
 * @since 2021/3/6 2:26
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null, tail = null;
        int remainder = 0;

        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + remainder;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            remainder = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (remainder > 0) {
            tail.next = new ListNode(remainder % 10);
        }
        return head;
    }

    public ListNode addTwoNumbersSecond(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode current = head;

        int remainder = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + remainder;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            remainder = sum / 10;
        }
        if (remainder > 0) {
            current.next = new ListNode(remainder % 10);
        }
        return head.next;
    }

}
package top.irvingsoft.code.linkedlist;

import top.irvingsoft.structure.Node;

/**
 * 链表操作
 *
 * @author TimeChaser
 * @since 2021/8/7 14:18
 */
public class Solution {

    public static Node listSuffix = null;

    public static void main(String[] args) {

        Node node = new Node(8);
        node.next = new Node(1);
        node.next.next = new Node(5);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(9);
        node.next.next.next.next.next = new Node(7);

        Node reverse = reverseListRecursion(node, 4);
        traverseList(reverse);
    }

    public static Node reverseListNormal(Node head, Node tail) {

        Node last = null, cur = head;
        while (cur != tail) {
            Node temp = cur.next;
            cur.next = last;
            last = cur;
            cur = temp;
        }
        return last;
    }

    /**
     * 依次遍历每一个结点组成一个翻转链
     *
     * @since 2021/8/7 15:25
     */
    public static Node reverseListNormal(Node head) {

        Node last = null, cur = head;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = last;
            last = cur;
            cur = temp;
        }
        return last;
    }

    /**
     * 翻转链表的前 length 个结点
     *
     * @since 2021/8/7 15:15
     */
    public static Node reverseListRecursion(Node head, int length) {

        if (length == 1 || head.next == null) {

            listSuffix = head.next;
            return head;
        }

        Node last = reverseListRecursion(head.next, length - 1);
        head.next.next = head;
        head.next = listSuffix;
        return last;
    }

    /**
     * 翻转部分链表
     *
     * @param head   头结点
     * @param index  起始下标
     * @param length 长度
     * @since 2021/8/7 15:47
     */
    public static void reverseListRecursion(Node head, int index, int length) {

        if (index == 1) {
            head.next = reverseListRecursion(head.next, length);
            return;
        }

        reverseListRecursion(head.next, index - 1, length);
    }

    /**
     * 翻转链表
     *
     * @since 2021/8/7 15:16
     */
    public static Node reverseListRecursion(Node head) {

        // 如果不存在后续结点，则原链表的尾结点作为新链表的头结点返回
        if (head.next == null) {
            return head;
        }

        Node last = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void traverseList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}

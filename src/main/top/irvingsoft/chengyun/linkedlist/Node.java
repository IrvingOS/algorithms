package top.irvingsoft.chengyun.linkedlist;

/**
 * 单链表
 *
 * @author TimeChaser
 * @since 2021/9/7 23:24
 */
public class Node {

    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
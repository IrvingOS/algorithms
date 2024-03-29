package top.irvingsoft.leetcode.code559;

import java.util.List;

class Node {

    public List<Node> children;
    public int val;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

}

/**
 * N 叉树的最大深度
 *
 * @author TimeChaser
 * @since 2021/11/21 22:02
 */
public class Solution {

    private int max = 0;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return max;
    }

    private void dfs(Node node, int depth) {
        if (node.children == null || node.children.size() == 0) {
            max = Math.max(max, depth);
            return;
        }
        for (Node child : node.children) {
            dfs(child, depth + 1);
        }
    }

};
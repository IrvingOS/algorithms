package top.irvingsoft.foroffer.code54;

/**
 * 树结点
 *
 * @author TimeChaser
 * @since 2021/11/13 9:40
 */
public class TreeNode {

    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

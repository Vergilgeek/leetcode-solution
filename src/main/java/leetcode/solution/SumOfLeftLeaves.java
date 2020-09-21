package leetcode.solution;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 */
public class SumOfLeftLeaves {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public int solution(TreeNode root) {
        if (null == root.left) {
            return 0;
        }
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        int result = 0;
        if (null != node.left) {
            result += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            result += dfs(node.right);
        }
        return result;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

}

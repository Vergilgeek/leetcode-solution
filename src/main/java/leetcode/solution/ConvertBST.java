package leetcode.solution;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 */
public class ConvertBST {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;
    /**
     * 方法一：反序中序遍历
     * 反序中序遍历该二叉搜索树，记录过程中的节点值之和，并不断更新当前遍历到的节点的节点值，即可得到题目要求的累加树。
     */
    public TreeNode solution1(TreeNode root) {
        if(root != null){
            solution1(root.right);
            sum += root.val;
            root.val = sum;
            solution1(root.left);
        }
        return root;
    }
}
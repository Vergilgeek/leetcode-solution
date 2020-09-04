package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径
 */
public class BinaryTreePaths {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 深度优先搜索
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> linkList = new ArrayList<>();
        StringBuilder link = new StringBuilder();
        find(linkList, link, root);
        return linkList;
    }

    private void find(List<String> linkList, StringBuilder link, TreeNode tree) {
        if (tree == null) {
            return;
        }
        StringBuilder newLink = new StringBuilder(link);
        newLink.append(Integer.toString(tree.val));
        if (tree.left == null  && tree.right == null) {
            linkList.add(newLink.toString());
        } else {
            newLink.append("->");
            find(linkList, newLink, tree.left);
            find(linkList, newLink, tree.right);
        }
    }
    
}
package leetcode.solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 */
public class PostorderTraversal {

    /**
     * 递归
     * 定义 postorder(root) 表示当前遍历到 root 节点的答案。
     * 按照定义，只要递归调用 postorder(root->left) 来遍历 root 节点的左子树，然后递归调用 postorder(root->right) 来遍历 root 节点的右子树，
     * 最后将 root 节点的值加入答案即可，递归终止的条件为碰到空节点
     */
    public List<Integer> solution1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }


    /**
     *  迭代
     * 也可以用迭代的方式实现方法一的递归函数，两种方式是等价的，区别在于递归的时候隐式地维护了一个栈，而我们在迭代的时候需要显式地将这个栈模拟出来
     */
    public List<Integer> solution2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null || root.right == prev){
                res.add(root.val);
                prev = root;
                root = null;
            } else{
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    // Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    
}

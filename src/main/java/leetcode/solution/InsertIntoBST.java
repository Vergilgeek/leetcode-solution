package leetcode.solution;

/**
 * 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 */
public class InsertIntoBST {

    /**
     * 递归实现
     * 首先回顾二叉搜索树的性质：对于任意节点 root 而言，左子树（如果存在）上所有节点的值均小于 root.val，右子树（如果存在）上所有节点的值均大于 root.val，且它们都是二叉搜索树。
     * 因此，当将val 插入到以 root 为根的子树上时，根据 val 与 root.val 的大小关系，就可以确定要将 val 插入到哪个子树中。
     * 如果该子树不为空，则问题转化成了将 val 插入到对应子树上。
     * 否则，在此处新建一个以val 为值的节点，并链接到其父节点root 上。
     * 
     * 复杂度分析
     * 时间复杂度：O(N)O(N)，其中 NN 为树中节点的数目。最坏情况下，我们需要将值插入到树的最深的叶子结点上，而叶子节点最深为 O(N)O(N)。
     * 空间复杂度：O(1)O(1)。我们只使用了常数大小的空间。
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        buildTree(root, val);
        return root;
    }

    private void buildTree(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                insertIntoBST(node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                insertIntoBST(node.right, val);
            }
        }
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
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

}

package leetcode.solution;

import java.util.LinkedList;

/**
 * 117. 填充每个节点的下一个右侧节点指针 
 * II 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next
 * 指针设置为 NULL。 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class ConnectTree {
    /**
     * 层次遍历 这道题希望我们把二叉树各个层的点组织成链表，一个非常直观的思路是层次遍历。树的层次遍历基于广度优先搜索，它按照层的顺序遍历二叉树，在遍历第 ii
     * 层前，一定会遍历完第 i - 1i−1 层。 算法如下：初始化一个队列 qq，将根结点放入队列中。当队列不为空的时候，记录当前队列大小为
     * nn，从队列中以此取出 nn 个元素并通过这 nn 个元素拓展新节点。如此循环，直到队列为空。
     */
    public Node solution1(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 1; i <= n; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i != 1) {
                    last.next = node;
                }
                last = node;
            }
        }
        return root;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}

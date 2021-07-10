/*
226. Invert Binary Tree
https://leetcode.com/problems/invert-binary-tree/
*/


import java.util.Deque;
import java.util.Queue;

class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;

    }

    private void invert(TreeNode node) { //current node swaps child  elements. current will be  swapped by its parent.
        if (node == null) return;
        invert(node.left);
        invert(node.right);

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

    }
}
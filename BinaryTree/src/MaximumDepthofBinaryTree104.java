/*

        104.Maximum Depth of Binary Tree
        https://leetcode.com/problems/maximum-depth-of-binary-tree/

*/

class MaximumDepthofBinaryTree104 {
    public int maxDepth(TreeNode root) {
        return findDepth(root);
    }

    private int findDepth(TreeNode node) {
        if (node == null) return 0;

        return 1 + Math.max(findDepth(node.left), findDepth(node.right));
    }
}

class TreeNode {
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
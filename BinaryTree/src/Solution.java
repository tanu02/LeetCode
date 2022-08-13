/*
124. Binary Tree Maximum Path Sum
https://leetcode.com/problems/binary-tree-maximum-path-sum/

*/

class Solution {
    int maxLen;

    public int maxPathSum(TreeNode root) {
        maxLen = Integer.MIN_VALUE;
        findMaxPath(root);
        return maxLen;
    }

    private int findMaxPath(TreeNode node) {
        if (node == null) return 0;

        int leftSum = Math.max(0, findMaxPath(node.left)); //same as max sum problem current  should always increase
        int rightSum = Math.max(0, findMaxPath(node.right));

        maxLen = Math.max(maxLen, node.val + leftSum + rightSum);   //including current what is the max path
        return node.val + Math.max(leftSum, rightSum);             //including current and chose b/w left and right

    }
}

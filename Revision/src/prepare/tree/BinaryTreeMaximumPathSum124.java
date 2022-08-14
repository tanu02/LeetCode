package prepare.tree;

public class BinaryTreeMaximumPathSum124 {
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
         getMaxPath(root);
         return maxPath;
    }

    private int getMaxPath(TreeNode node){
        if(node == null) return 0;

        int leftSum = Math.max(getMaxPath(node.left), 0);
        int rightSum = Math.max(getMaxPath(node.right), 0);

        maxPath = Math.max(maxPath, node.val + leftSum + rightSum);
        return node.val + Math.max(leftSum, rightSum);
    }
}

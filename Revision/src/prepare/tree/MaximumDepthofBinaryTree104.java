package prepare.tree;

public class MaximumDepthofBinaryTree104 {

    public int maxDepth(TreeNode node){
        if(node == null) return 0;

        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}

package prepare.tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            swap(node);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return root;
    }

    private void swap(TreeNode node) {
        TreeNode temp = node.left;

        node.left = node.right;
        node.right = temp;
    }

}

package prepare.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.w3c.dom.Node;

public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null) return new ArrayList<>();

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            List<List<Integer>> output =  new ArrayList<>();
            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> level = new ArrayList<>();
                for(int i = 0; i < size; i++){
                    TreeNode node = q.poll();
                    level.add(node.val);
                    if(node.left != null) q.add(node.left);
                    if(node.right != null) q.add(node.right);
                }
                output.add(level);
            }
            return output;
    }

}

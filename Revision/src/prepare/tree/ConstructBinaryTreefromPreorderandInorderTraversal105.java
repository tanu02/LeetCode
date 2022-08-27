package prepare.tree;

import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || inorder.length == 0) return null;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return createTree(map, 0, inorder.length - 1, preorder);
    }

    private TreeNode createTree(Map<Integer, Integer> map, int st, int end, int[] preorder){
            if(st > end) return null;
            int val = preorder[index++];

            int nodeIndex = map.get(val);
            TreeNode node = new TreeNode(val);
            node.left = createTree(map, st, nodeIndex - 1, preorder);
            node.right = createTree(map, nodeIndex + 1, end, preorder);
            return node;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> outputList = new ArrayList<>();
    	if(root ==  null) return outputList; 
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root); 
        
    	int size = 0; 
    	while(!queue.isEmpty()) {
    		size = queue.size();
    		List<Integer> list = new ArrayList<>();
    		for(int i = 0; i < size; i++) { //level parsing
    			TreeNode node = queue.poll(); 
    			list.add(node.val);
    			if(node.left != null) queue.add(node.left);
    			if(node.right != null) queue.add(node.right);
    			
    		}
    		outputList.add(list); //add current level
    	}
    	return outputList; 
    }
}
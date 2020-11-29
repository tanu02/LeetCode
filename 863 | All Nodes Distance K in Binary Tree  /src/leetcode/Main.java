package leetcode;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		//convert tree to graph (dfs)
		//start from target 
		//bfs from target till k levels
		
		Solution sol = new Solution();
		
		TreeNode three = new TreeNode(3); 
		TreeNode five = new TreeNode(5); 
		TreeNode one = new TreeNode(1); 
		TreeNode six = new TreeNode(6); 
		TreeNode two = new TreeNode(2); 
		TreeNode zero = new TreeNode(0); 
		TreeNode eight = new TreeNode(8); 
		TreeNode seven = new TreeNode(7); 
		TreeNode four = new TreeNode(4);
		
		three.left = five; 
		three.right = one;	
		
		five.left = six; 
		five.right = two; 
		
		one.left = zero; 
		one.right = eight; 
		
		two.left = seven; 
		two.right = four;
		
		List<Integer> outputList = sol.distanceK(three, five, 2);
		outputList.forEach(val -> System.out.println(val));
	}
}
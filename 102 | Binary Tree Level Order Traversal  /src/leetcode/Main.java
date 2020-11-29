package leetcode;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		
		TreeNode three = new TreeNode(3);
		TreeNode nine = new TreeNode(9);
		TreeNode twenty = new TreeNode(20);
		TreeNode fifteen = new TreeNode(15);
		TreeNode seven = new TreeNode(7);
		
		three.left = nine; 
		three.right = twenty;
		twenty.left = fifteen; 
		twenty.right = seven; 
		List<List<Integer>> outputList  = sol.levelOrder(three);
		
		outputList.forEach(list -> {
								list.forEach(val -> System.out.print(val + "\t"));
								System.out.println();
				}
				);
		
	
	}
}
package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

class Solution {
	class TreeNode {
		String val;
		TreeNode left;
		TreeNode right;
	}
	Map<String, Function<TreeNode, Boolean>> map;
	private void init() {
		 map = new HashMap<>();
	
		map.put("and", (node1) -> evaluateExpression(node1.left) && evaluateExpression(node1.right));
		map.put("or", (node1) -> evaluateExpression(node1.left) || evaluateExpression(node1.right));
		map.put("true", (node1) -> evaluateExpression(node1.left) && evaluateExpression(node1.right));
		map.put("false", (node1) -> evaluateExpression(node1.left) && evaluateExpression(node1.right));
	}

	public boolean evaluateExpression(TreeNode node) {
		init();
		if (node == null)
			throw new IllegalArgumentException();
		
		Function<TreeNode, Boolean> fun = map.get(node.val);
		System.out.println(fun.apply(node)); 
		return true;
	}

	
}
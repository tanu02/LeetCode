package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> outputList = new ArrayList<>();
		if (root == null) return outputList;
		
		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);
		int size = 0;
		long sum  = 0;
		TreeNode node;
		
		while (!queue.isEmpty()) {
			size = queue.size();

			for (int i = 0; i < size; i++) { // process level
				node = queue.poll();
				sum += node.val;
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			
			outputList.add((sum * 1.0) / size);
			sum = 0;
		}
		return outputList;
	}
}
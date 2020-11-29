package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
	Map<TreeNode, TreeNode> parent = new HashMap<>();
	HashSet<TreeNode> visited = new HashSet<>();

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> outputList = new ArrayList<>();
		if (root == null)
			return outputList;

		dfs(root, null);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(target);
		int size = 0;
		TreeNode node;
		TreeNode parent;
		int level = 0;

		while (!queue.isEmpty()) {
			if (level == K) {
				while (!queue.isEmpty()) {
					outputList.add(queue.poll().val);
				}
				return outputList;
			}
			size = queue.size();

			for (int i = 0; i < size; i++) {
				node = queue.poll();
				visited.add(node);
				if (node.left != null && !visited.contains(node.left))
					queue.add(node.left);
				if (node.right != null && !visited.contains(node.right))
					queue.add(node.right);
				parent = this.parent.get(node);
				if (parent != null && !visited.contains(parent))
					queue.add(parent);
			}
			level++;
		}
		return outputList;
	}

	private void dfs(TreeNode node, TreeNode parent) {
		if (node == null)
			return;
		this.parent.put(node, parent);
		dfs(node.left, node);
		dfs(node.right, node);
	}
}
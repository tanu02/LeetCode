package leetcode;

class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		return createTree(nums, 0, nums.length - 1);

	}
	
	private TreeNode createTree(int[] arr, int st, int end) {
		if(st > end) return null;
		if (st == end) return new TreeNode(arr[st]);
		
		int mid = st + (end - st)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = createTree(arr, st, mid - 1);
		node.right = createTree(arr, mid + 1, end);
		
		return node;
		
	}
}

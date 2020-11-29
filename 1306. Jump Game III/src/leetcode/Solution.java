package leetcode;

class Solution {
	int[] arr;
	int[] dp; // 1 for not found 2 on finding target
				// which is 0

	public boolean canReach(int[] arr, int start) {
		this.arr = arr;
		dp = new int[arr.length];
		if(findZero(start) == 2) return true; 
		return false; 

	}

	private int findZero(int i) { 
		if (i < 0 || i >= arr.length || dp[i] == 1)
			return 1; // -ve
		if (arr[i] == 0)
			return 2; // +ve

		dp[i] = 1;
		int res = findZero(i - arr[i]);
		if (res == 2) {
			dp[i] = 2;
			return 2;

		}
		res = findZero(i + arr[i]);
		dp[i] = res;
		return res;

	}
}
package leetcode;

class Solution {
	int max = 0;

	public int maxSubArray(int[] nums) {

		return maxSum(nums);

	}

	private int maxSum(int[] arr) {

		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {

			if (arr[i] + arr[i - 1] >= arr[i]) {
				arr[i] += arr[i - 1];
				
			}
			if(arr[i] > max) max = arr[i];
		}
		return max;
	}
}
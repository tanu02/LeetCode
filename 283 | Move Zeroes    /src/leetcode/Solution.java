package leetcode;

class Solution {
	public void moveZeroes(int[] nums) {

		int j = 0;
		int len = nums.length;

		for (int i = 0; i < len & j < len; i++) {

			if (nums[i] == 0) {
				for (; j < len & j >= i; j++) {
					if (nums[j] != 0) {
						swap(nums, i, j);
						break;
					}
				}
			}

			j++;
		}

	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
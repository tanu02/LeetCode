package leetcode;

class Solution {

	public int majorityElement(int[] nums) {

		return getMajority(nums, 0, nums.length - 1);

	}

	private int getMajority(int[] nums, int start, int end) {
		if (start == end)
			return nums[start];
		int mid = start + (end - start) / 2;

		int lElem = getMajority(nums, start, mid);
		int rElem = getMajority(nums, mid + 1, end);
		if (lElem == rElem)
			return rElem;

		int lCount = count(nums, start, mid, lElem);
		int rCount = count(nums, mid + 1, end, rElem);

		if (lCount > rCount)
			return lElem;

		return rElem;

	}

	private int count(int[] nums, int start, int end, int elem) {
		int counter = 0;
		for (int i = start; i <= end; i++) {
			if (nums[i] == elem)
				counter++;
		}
		return counter;
	}
}
package leetcode;

class Solution {
	int[] arr;

	public int peakIndexInMountainArray(int[] arr) {
		this.arr = arr;
		return findPeak(0, arr.length - 1);

	}

	private int findPeak(int st, int end) {
		if (st == end)
			return st;
		int mid = st + (end - st) / 2;

		if (arr[mid + 1] > arr[mid])
			return findPeak(mid + 1, end);
		
		return findPeak(st, mid);

	}
}

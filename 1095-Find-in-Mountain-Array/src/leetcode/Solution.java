package leetcode;

class Solution {

	MountainArray arr;
	int target;

	public int findInMountainArray(int target, MountainArray mountainArr) {
		this.arr = mountainArr;
		this.target = target;
		
		int peak = findPeak(0, mountainArr.length() - 1);
		int res = -1;
		res = searchFirstHalf(0, peak);
		if (res != -1)
			return res;

		return searchSecondHalf(peak + 1, mountainArr.length() - 1);

	}
	private int searchSecondHalf(int st, int end) {
		if (st == end) {
			if (target == arr.get(st))
				return st;

			return -1;
		}
		int mid = st + (end - st) / 2;

		if(target < arr.get(mid)) return searchSecondHalf(mid + 1, end);
		return searchSecondHalf(st, mid);

		
	}

	private int searchFirstHalf(int st, int end) {
		if (st == end) {
			if (target == arr.get(st))
				return st;

			return -1;
		}
		int mid = st + (end - st) / 2;
		if (target > arr.get(mid))
			return searchFirstHalf(mid + 1, end);
		return searchFirstHalf(st, mid);

	}

	private int findPeak(int st, int end) {
		if (st == end)
			return st;
		int mid = st + (end - st) / 2;

		if (arr.get(mid + 1) > arr.get(mid))
			return findPeak(mid + 1, end);

		return findPeak(st, mid);

	}
}

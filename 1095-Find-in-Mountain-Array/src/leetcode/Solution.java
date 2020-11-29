package leetcode;

class Solution {

	MountainArray arr;
	int target;

	public int findInMountainArray(int target, MountainArray mountainArr) {
		this.arr = mountainArr;
		this.target = target;
		
		int peak = findPeak(0, mountainArr.length() - 1);
		int res = -1;
		res = search(0, peak);
		if (res != -1)
			return res;

		return search1(peak + 1, mountainArr.length() - 1);

	}
	private int search1(int st, int end) {
		if (st == end) {
			if (target == arr.get(st))
				return st;

			return -1;
		}
		int mid = st + (end - st) / 2;
		
		if(target < arr.get(mid)) return search1(mid + 1, end);
		return search1(st, mid);
		
		
	}

	private int search(int st, int end) {
		if (st == end) {
			if (target == arr.get(st))
				return st;

			return -1;
		}
		int mid = st + (end - st) / 2;
		if (target > arr.get(mid))
			return search(mid + 1, end);
		return search(st, mid);

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

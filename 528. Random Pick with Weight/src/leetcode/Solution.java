package leetcode;

class Solution {

	int[] coordinates;
	int totalSum;

	public Solution(int[] w) {
		this.coordinates = new int[w.length];

		for (int i = 0; i < w.length; i++) {
			totalSum += w[i];
			coordinates[i] = totalSum;
		}
	}

	public int pickIndex() {
		double target = Math.random() * totalSum;
		return findRandom(0, coordinates.length, target);

	}

	private int findRandom(int st, int end, double target) {
		if (st == end)
			return st;
		int mid = st + (end - st) / 2;

		if (target > coordinates[mid])
			return findRandom(mid + 1, end, target);

		return findRandom(st, mid, target);

	}
}
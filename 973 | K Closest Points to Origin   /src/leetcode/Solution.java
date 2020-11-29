package leetcode;

import java.util.Arrays;

class Solution {
	int[][] arr;
	int ROW;
	int COL;
	int k;

	public int[][] kClosest(int[][] points, int K) {

		if (points == null || points.length == 0 || points[0].length == 0)
			return new int[][] {};
		ROW = points.length;
		COL = points[0].length;
		this.arr = points;
		this.k = K;
		findKClosest(0, ROW - 1);
		return Arrays.copyOfRange(arr, 0, k);
	}

	private void findKClosest(int st, int end) {
		if (st >= end)
			return;
		int part = partition(st, end);
		if (k == part)
			return;
		if (k < part) {
			findKClosest(st, part - 1);
		} else
			findKClosest(part + 1, end);

	}

	private int partition(int st, int end) {
		int[] piv = arr[end];
		int lastLargerElement = st;

		for (int i = st; i < end; i++) {
			if (dist(arr[i]) <= dist(piv)) {
				swap(i, lastLargerElement++);
			}
		}
		swap(lastLargerElement, end); // either pivot will be the last largest elem or sth in between or the starting
										// element
		return lastLargerElement;
	}

	private void swap(int i, int j) {
		int[] temp = { arr[j][0], arr[j][1] };

		arr[j][0] = arr[i][0];
		arr[j][1] = arr[i][1];
		arr[i][0] = temp[0];
		arr[i][1] = temp[1];

	}

	private int dist(int[] coordinates) {
		return coordinates[0] * coordinates[0] + coordinates[1] * coordinates[1];
	}

}
package leetcode;

import java.util.Arrays;

class Solution {
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0 || intervals[0].length == 0 )
			return 0;
		
		Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
		int intervalCount = 1;
		int[] prevInterval = intervals[0];

		for (int i = 1; i < intervals.length; i++) {
			int curr[] = intervals[i];																											

			if (curr[0] >= prevInterval[1]) {
				intervalCount++;
				prevInterval = curr;
			}
		}
		return intervals.length - intervalCount;
	}
}


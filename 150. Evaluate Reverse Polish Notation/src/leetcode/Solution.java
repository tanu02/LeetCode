package leetcode;

class Solution {
	public int findPoisonedDuration(int[] timeSeries, int duration) {

		if (timeSeries == null || timeSeries.length == 0 || duration == 0) return 0;
		
		int ans = duration;

		for (int i = 1; i < timeSeries.length; i++) {
			ans += Math.min(timeSeries[i] - timeSeries[i-1], duration); 
		}

		return ans;
	}
}
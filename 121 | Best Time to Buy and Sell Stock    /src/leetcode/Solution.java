package leetcode;

class Solution {

	public int maxProfit(int[] prices) {

		int profit = 0;
		int minValue = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minValue)
				minValue = prices[i];
			else if (prices[i] - minValue > profit)
				profit = prices[i] - minValue;
		}
		return profit;

	}
}
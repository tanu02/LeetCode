package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int[] prices1 = { 7, 6, 4, 3, 1 };
		int[] prices2 = { 2, 4, 1 };
		System.out.println(sol.maxProfit(prices));
		System.out.println(sol.maxProfit(prices1));
		System.out.println(sol.maxProfit(prices2));

	}

}

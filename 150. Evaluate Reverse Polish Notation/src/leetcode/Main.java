package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[] timeSeries = { 1, 4 };
		int duration = 2;
		System.out.println(sol.findPoisonedDuration(timeSeries, duration));
		
		int[] timeSeries1 = { 1, 2 };
		int duration1 = 2;
		System.out.println(sol.findPoisonedDuration(timeSeries1, duration1));
	}

}
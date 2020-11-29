package leetcode;

public class Main {

	public static void main(String args[]) {

		Solution sol = new Solution();
		int[][] arr = { { 1, 3 }, { -2, 2 } };
		int k = 1;
		int[][] outputArray = sol.kClosest(arr, k);

		for (int[] coordinates : outputArray) {
			System.out.print(coordinates[0] + "\t" + coordinates[1]);
			System.out.println();
		}

	}
}
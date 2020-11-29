package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();

		int[] arr5 = { 1, 2, 3, 1 };
		int[] arr1 = { 1, 2, 1, 3, 5, 6, 4 };

		System.out.println(sol.findPeakElement(arr5));
		System.out.println(sol.findPeakElement(arr1));

	}

}

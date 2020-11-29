package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[] arr = {2,2,1,1,1,2,2}; // 2
		int[] arr1 = {3,2,3}; // 3
		System.out.println(sol.majorityElement(arr));
		System.out.println(sol.majorityElement(arr1));
	}
}
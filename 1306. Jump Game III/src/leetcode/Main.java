package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[] arr = {4,2,3,0,3,1,2};
		int start = 5;
		
		int[] arr1 = {4,2,3,0,3,1,2};
		int start1 = 0;
		
		int[] arr2 = {3,0,2,1,2};
		int start2 = 2;
		System.out.println(sol.canReach(arr, start));
		System.out.println(sol.canReach(arr1, start1));
		System.out.println(sol.canReach(arr2, start2));
	}
}
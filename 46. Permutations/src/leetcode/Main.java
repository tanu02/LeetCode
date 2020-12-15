package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[] arr = {2,3,1,1,4};
		
		int[] arr1 = {3,2,1,0,4};
		
		int[] arr3 = {1,0,1,0};
		//int[] arr3 = {0};
		//int[] arr3 = {0, 2, 3};
		//int[] arr3 = {2, 0}; 
		
		//System.out.println(sol.canJump(arr));
		System.out.println(sol.canJump(arr3));
	}
}
package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[][]arr = {
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
				};
		
		int target = 20;
		
		int [][] arr1 = {{}};
		System.out.println(sol.searchMatrix(arr1, target));
		

	}
}
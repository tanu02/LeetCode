package leetcode;

public class Main {

	public static void main(String[] args) {

		Searcha2DMatrix74 sol = new Searcha2DMatrix74();
		int[][]arr = {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				 {23, 30, 34, 50}
				};
		
		int[][] arr1 = 
			{
				  {1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}
			};
		
		int [][] arr2 = {{}};
		int [][] arr3 = {};
		System.out.println(sol.searchMatrix(arr, 3));
		System.out.println(sol.searchMatrix(arr1, 13));
		System.out.println(sol.searchMatrix(arr2, 0));
		System.out.println(sol.searchMatrix(arr3, 1));
		

	}
}
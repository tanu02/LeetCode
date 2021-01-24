package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		char[][] arr = {
				  {'1','1','1','1','0'},
				  {'1','1','0','1','0'},
				  {'1','1','0','0','0'},
				  {'0','0','0','0','0'}
				};
		
		char[][] arr1 = 
					{
				  {'1','1','0','0','0'},
				  {'1','1','0','0','0'},
				  {'0','0','1','0','0'},
				  {'0','0','0','1','1'}
				};
		
		char[][] arr2 = {};
		char[][] arr3 = {{}};
		
		char[][] arr4 =
				{
						
				{'1','1','1'},
				{'0','1','0'},
				{'1','1','1'}
						
				};
		
		char[][] arr5 = 
			{
				 {'1','0','1','1','1'},
				 {'1','0','1','0','1'},
				 {'1','1','1','0','1'}
	};
		System.out.println(sol.numIslands(arr));
//		System.out.println(sol.numIslands(arr1));
//		System.out.println(sol.numIslands(arr2));
//		System.out.println(sol.numIslands(arr3));
//		System.out.println(sol.numIslands(arr4));
//		System.out.println(sol.numIslands(arr5));

	}
}
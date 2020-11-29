package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[][] grid = { 
				{ 1, 1, 0, 0, 0 }, 
				{ 1, 1, 0, 0, 0 }, 
				{ 0, 0, 0, 1, 1 }, 
				{ 0, 0, 0, 1, 1 } 
				};
//		System.out.println(sol.numDistinctIslands(grid));
		
		int[][] grid1 = { 
				{ 1, 1, 0, 1, 1 }, 
				{ 1, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 1 }, 
				{ 1, 1, 0, 1, 1 } 
				};
	//	System.out.println(sol.numDistinctIslands(grid1));
		
		int[][] grid2 = {
				{0,0,1},
				{0,0,1},
				{1,1,0}
				};
		System.out.println(sol.numDistinctIslands(grid2));
		
	
	}
		


}

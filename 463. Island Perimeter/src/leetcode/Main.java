package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		int[][] grid1 = { { 1 } };
		int[][] grid2 = { { 1, 0 } };
		System.out.println(sol.islandPerimeter(grid));
		System.out.println(sol.islandPerimeter(grid1));
		System.out.println(sol.islandPerimeter(grid2));

	}

}

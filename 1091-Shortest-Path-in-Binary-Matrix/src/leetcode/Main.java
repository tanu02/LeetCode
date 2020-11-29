package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[][] grid = {{0,1},{1,0}}; //2
		int[][] grid1 = {{0,0,0},{1,1,0},{1,1,0}}; //4

		int[][] grid2 = {{1,0,0},{1,1,0},{1,1,0}}; //-1
		int [][] grid3 = {{0,0,1,0,0,0,0}, //10
				{0,1,0,0,0,0,1},
				{0,0,1,0,1,0,0},
				{0,0,0,1,1,1,0},{1,0,0,1,1,0,0},{1,1,1,1,1,0,1},{0,0,1,0,0,0,0}};
		int[][] grid4 =		{{0}};
		System.out.println(sol.shortestPathBinaryMatrix(grid));
		System.out.println(sol.shortestPathBinaryMatrix(grid1));
		System.out.println(sol.shortestPathBinaryMatrix(grid2));
		System.out.println(sol.shortestPathBinaryMatrix(grid3));
		System.out.println(sol.shortestPathBinaryMatrix(grid4));

	}

}

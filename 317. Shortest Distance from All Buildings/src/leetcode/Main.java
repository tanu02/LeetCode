package leetcode;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		int[][] arr = {
				{1,0,2,0,1},
				{0,0,0,0,0},
				{0,0,1,0,0}
		};
		System.out.println(sol.shortestDistance(arr)); 
		
}
}
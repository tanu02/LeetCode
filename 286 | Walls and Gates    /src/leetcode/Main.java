package leetcode;

public class Main {

	public static void main(String[] args) {
		int INF = 2147483647;
		
		Solution sol = new Solution();
		int[][]arr = {
				{INF,  -1,  0,  INF},
				{INF, INF, INF,  -1},
				{INF,  -1, INF,  -1},
				{0, -1, INF, INF}
				};
		int[][] arr1 = {};
		sol.wallsAndGates(arr);
		sol.wallsAndGates(arr1);
		printArray(arr);

	}
	
	private static void printArray(int[][] arr){
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0 ; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
		
}
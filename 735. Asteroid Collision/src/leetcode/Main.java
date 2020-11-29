package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		//int[] arr = { 5, 10, -5 }; // {5, 10}
		//int[] arr = { 8, -8 }; // {}
		//int[] arr = { 10, 2, -5 }; //{10}
		//int[] arr = { -2, -1, 1, 2 }; // { -2, -1, 1, 2 }
		//int[] arr = {-2,-2,1,-2}; // {-2, -2, -2}
		//int[] arr = {10, 2, 1, -10};
		//int[] arr = {100, 2, 1, -10};
		int[] arr = {2, 1, 10, -10};
		int[] output ;
		output = sol.asteroidCollision(arr);
		
		for(int val : output) {
			System.out.print(val + "\t");
		}
	}
}
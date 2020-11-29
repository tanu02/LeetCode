package leetcode;

public class Main {

	public static void main(String[] args) {

		int[] w = { 1, 3 };
		int[] w1 = { 1 };
		
		int[] w2 = {3,14,1,7};
		
		Solution sol = new Solution(w2);
		
		System.out.println(sol.pickIndex());
		System.out.println(sol.pickIndex());
	}

}

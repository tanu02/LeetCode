package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		
		//int[] arr = {1,1,1,2,2,3};
		//int k = 2;
		int[] arr = {1};
		int k = 1;
		int[] outputArr = sol.topKFrequent(arr, k);
		for(int val : outputArr) {
			System.out.println(val);
		}
		
		Solution sol2 = new Solution();
		
		int[] outputArr1 = sol2.topKFrequent(arr, k);
		for(int val : outputArr1) {
			System.out.println(val);
		}

	}

}

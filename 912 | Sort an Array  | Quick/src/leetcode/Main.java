package leetcode;

public class Main {

	public static void main(String args[]) {
		int arr[] = {-4,0,7,4,9,-5,-1,0,-7,-1};
		//int arr[] = {5,1,1,2,0,0};

		Solution sol = new Solution();
		int[] outputArray = sol.sortArray(arr);
		
		for(int val : outputArray) {
			System.out.print(val + "\t");
		}
	}

}
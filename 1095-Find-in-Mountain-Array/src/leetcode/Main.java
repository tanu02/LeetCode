package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();

		int[] arr = {1,5,2};

		//int[] arr = {0,5,3,1};
		MountainArrayImpl mountain = new MountainArrayImpl(arr); 
		
		System.out.println(sol.findInMountainArray(2, mountain)); 
		//System.out.println(sol.findInMountainArray(3, mountain)); 
	}

}

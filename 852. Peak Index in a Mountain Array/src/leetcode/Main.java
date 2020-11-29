package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		
		int[] arr5 = {0,1,0};
		int[] arr1 = {0,2,1,0};
		int[] arr2 = {0,10,5,2};
		int[] arr3 = {3,4,5,1};
		int[] arr4 = {24,69,100,99,79,78,67,36,26,19};
		
		
		System.out.println(sol.peakIndexInMountainArray(arr5));
		System.out.println(sol.peakIndexInMountainArray(arr1));
		System.out.println(sol.peakIndexInMountainArray(arr2));
		System.out.println(sol.peakIndexInMountainArray(arr3));
		System.out.println(sol.peakIndexInMountainArray(arr4));

	}

}

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[] arr = {1,2,3,4,5}; int k = 4; int x = 3;
		int[] arr1 = {1,2,3,4,5}; int  k1 = 4; int x1 = -1;

		System.out.println(sol.findClosestElements(arr, k, x));
		System.out.println(sol.findClosestElements(arr1, k1, x1));


	}
		
}
package leetcode;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution(); 
		int[] flowerbed = {1,0,0,0,1}; 
		int n = 1;
		System.out.println(sol.canPlaceFlowers(flowerbed, n));
		
		int[] flowerbed2 = {1,0,1,0,1,0,1};
		int n2 = 0;
		System.out.println(sol.canPlaceFlowers(flowerbed2, n2));


	}
		
}
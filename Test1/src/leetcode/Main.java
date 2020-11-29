package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		Integer[] arr = {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0};
		Integer[] arr1 = {4, 2, 0, 3, 0};
		
		System.out.println(sol.computeSnowpack(arr1));
		System.out.println(sol.computeSnowpack(arr));

}
}
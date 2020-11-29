package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		//int[] arr1 = { 0, 1, 0, 3, 12 };
		//int[] arr1 = { 1, 0};
		//int[] arr1 = { 0, 1};
		int[] arr1 = { 0, 0};
		
		sol.moveZeroes(arr1);
		List<Integer> list = Arrays.stream(arr1) // IntStream
									.boxed() // Stream<Integer>
									.collect(Collectors.toList());
		list.forEach(val -> System.out.println(val));
	}

}

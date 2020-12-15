package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[] arr = { 2, 7, 11, 15 };
		int[] arr1 = {3,2,4};
		int[] arr2 = {3,3};
		
		int[] ans = sol.twoSum(arr2, 6);

		if (ans != null) {
			List<Integer> list = Arrays.stream(ans) // IntStream
					.boxed() // Stream<Integer>
					.collect(Collectors.toList());
			list.forEach(val -> System.out.println(val));
		}

	}
}
package leetcode;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 2;
		
	//	List<String> list = sol.topKFrequent(arr, k);
	//	list.forEach(val -> System.out.print(val + "\t"));

		System.out.println();
		String[] arr1 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		int k1 = 4;
		
		List<String> list1 = sol.topKFrequent(arr1, k1);
		list1.forEach(val -> System.out.print(val + "\t"));
	}

}

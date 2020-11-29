package leetcode;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		//String s = "ababcbacadefegdehijhklij";
		//String s = "abacbde";
		String s = "vhaagbqkaq";
		List<Integer> list = sol.partitionLabels(s);
		list.forEach(val -> System.out.println(val));

	}
}
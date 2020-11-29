package leetcode;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int n = 6; 
		int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
		
		List<Integer> list = sol.findMinHeightTrees(n, edges);
		list.forEach(node -> System.out.print(node + "\t"));

		System.out.println();
		
		int[][] edges1 = {};
		List<Integer> list1 = sol.findMinHeightTrees(1, edges1);
		list1.forEach(node -> System.out.print(node + "\t"));
		System.out.println();
		int[][] edges2 = {{0,1}};
		List<Integer> list2 = sol.findMinHeightTrees(2, edges2);
		list2.forEach(node -> System.out.print(node + "\t"));

	}

}

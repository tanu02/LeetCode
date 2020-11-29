package leetcode;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();

		TreeNode three = new TreeNode(3);
		TreeNode nine = new TreeNode(9);
		TreeNode twenty = new TreeNode(20);
		TreeNode fifteen = new TreeNode(15);
		TreeNode seven = new TreeNode(7);

		three.left = nine;
		three.right = twenty;
		twenty.left = fifteen;
		twenty.right = seven;
		
		
		System.out.println(2147483647 + 2147483647);
		List<Double> outputList  = sol.averageOfLevels(three);
		
		outputList.forEach(val -> {
				System.out.print(val + "\t");
				System.out.println();
		}
		);
		TreeNode first = new TreeNode(2147483647);
		TreeNode sec = new TreeNode(2147483647+2147483647);
		TreeNode third = new TreeNode(2147483647);

		first.left = sec;
		first.right = third;
		List<Double> outputList1 = sol.averageOfLevels(first);

		outputList1.forEach(val -> {
			System.out.print(val + "\t");
			System.out.println();
		});
	}
}
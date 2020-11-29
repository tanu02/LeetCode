package leetcode;


public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		
		String[] arr = {"2", "1", "+", "3", "*"};
		System.out.println(sol.evalRPN(arr)); //9
		
		Solution sol1 = new Solution();
		String[] arr1 = {"4", "13", "5", "/", "+"};
		System.out.println(sol1.evalRPN(arr1)); //6
		
		Solution sol2 = new Solution();
		String[] arr2 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(sol2.evalRPN(arr2)); //6
		

	}

}

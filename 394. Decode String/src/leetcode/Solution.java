package leetcode;

import java.util.Stack;

class Solution {
	public String decodeString(String s) {

		char[] arr = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int k = 0;
		for (char ch : arr) {
			if (ch == ']') {
				while (stack.peek() != '[') {
					sb.append(stack.pop());
				}

				stack.pop();// pop '['
				k = getCount(stack);
				pushDecodedString(sb, k, stack);
				sb.setLength(0);
			}
			else
				stack.push(ch);
		}

		return getString(stack);
	}

	private void pushDecodedString(StringBuilder sb, int k, Stack<Character> stack) {

		char[] arr = sb.toString().toCharArray();
		for (int i = 0; i < k; i++) {
			for (int j = arr.length - 1; j >= 0; j--) {
				stack.push(arr[j]);
			}

		}
	}

	private String getString(Stack<Character> stack) {
		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			sb.append(c);
		}
		return sb.toString();
	}

	private int getCount(Stack<Character> stack) {
		int k = 0;
		int base = 0;
		while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
			k += Math.pow(10, base++) * (stack.pop() - '0');
		}
		return k;
	}
}
package leetcode;

import java.util.Stack;

class Solution {

	public String simplifyPath(String path) {
		String[] tokens = path.split("/");
		Stack<String> stack = new Stack<>();
		for (String token : tokens) {
			if (token.isEmpty() || token.equals("."))
				continue;
			if (token.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(token);
			}

		}

		return createPath(stack);
	}

	private String createPath(Stack<String> stack) {

		StringBuilder sb = new StringBuilder();

		for (String st : stack) {
			sb.append("/");
			sb.append(st);
		}
		return sb.length() == 0 ? "/" : sb.toString();
	}
}

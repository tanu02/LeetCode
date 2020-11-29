package leetcode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

class Solution {
	Map<String, BiFunction<Integer, Integer, Integer>> operatorMap;

	private void init() {
		this.operatorMap = new HashMap<>();
		operatorMap.put("+", (a, b) -> a + b);
		operatorMap.put("-", (a, b) -> a - b);
		operatorMap.put("*", (a, b) -> a * b);
		operatorMap.put("/", (a, b) -> a / b);

	}

	public int evalRPN(String[] tokens) {
		init();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			if (!operatorMap.containsKey(tokens[i])) {
				stack.push(Integer.parseInt(tokens[i]));
				continue;
			}
			BiFunction<Integer, Integer, Integer> function = operatorMap.get(tokens[i]);
			int num2 = stack.pop(); 
			int num1 = stack.pop(); 
			int val = function.apply(num1, num2); 
			stack.push(val);
		}

		return stack.pop();
	}
}
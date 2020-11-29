package leetcode;

import java.util.Stack;

class Solution {
	public int[] asteroidCollision(int[] asteroids) {
		if (asteroids == null || asteroids.length == 0)
			return new int[] {};
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < asteroids.length; i++) {

			if (asteroids[i] < 0 && !stack.isEmpty() && stack.peek() > 0) {
				while (asteroids[i] < 0 && !stack.isEmpty() && stack.peek() > 0) {

					if (-asteroids[i] > stack.peek()) {
						stack.pop();
						continue;
					}
					break;
				}
				if (!stack.isEmpty() && stack.peek() > 0) {
					if (-asteroids[i] == stack.peek())
						stack.pop(); // same size blast both
				} else
					stack.push(asteroids[i]); //either top is -ve ||  
			} else
				stack.push(asteroids[i]);

		}

		int[] outputList = new int[stack.size()];
		int index = 0;
		for (int val : stack) {
			outputList[index++] = val;
		}
		return outputList;

	}
}
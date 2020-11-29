package leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {

	public List<String> fizzBuzz(int n) {
		
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {

			if (i % 3 == 0)
				sb.append(Val.FIZZ);
			if (i % 5 == 0)
				sb.append(Val.BUZZ);
			
			if (sb.length() == 0)
				list.add(Integer.toString(i));
			else
				list.add(sb.toString());
			
			sb.setLength(0);
		}
		return list;

	}

	enum Val {
		FIZZ("Fizz"), BUZZ("Buzz");
		String elem;

		Val(String elem) {
			this.elem = elem;
		}

		@Override
		public String toString() {
			return this.elem;

		}
	}
}
package leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution {

	public int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		Character c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);

		}
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}
}
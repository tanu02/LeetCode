package leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> partitionLabels(String S) {
		List<Integer> outputList = new ArrayList<>();
		if(S == null) return outputList; 
		int st = 0; int end = 0; int len = S.length();
		int[] index = new int[26];
		
		for (int i = 0; i < S.length(); i++) {
			index[S.charAt(i) - 'a'] = i;
		} // last location of a character

		
		while (st < len) {

			for (int i = st; i <= end; i++) {
				int lastLoc = S.charAt(i) - 'a';
				if (index[lastLoc] > end)
						end = index[lastLoc];
			}
			outputList.add(end - st + 1);
			st = end + 1;
			end = st;
		}
		return outputList;
	}
}
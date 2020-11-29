package leetcode;

import java.util.PriorityQueue;

class Solution {
	public String reorganizeString(String S) {

		PriorityQueue<CharacterCount> pq = new PriorityQueue<>(
				(a1, a2) -> a2.count - a1.count);
		int[] countArray = new int[26];
		for(char c : S.toCharArray()) {
			countArray[c-'a']++;
		}
		int n = S.length(); 
		for (int i = 0; i < countArray.length; i++) {
			if(countArray[i] >= (n+1)/2 + 1) return "";
			if(countArray[i] > 0)
				pq.add(new CharacterCount((char)('a' + i) , countArray[i]));	
		}
		CharacterCount top1;
		CharacterCount top2;
		StringBuilder sb = new StringBuilder();
		while (pq.peek().count != 0) {
			top1 = pq.poll();
			top2 = pq.poll();
			sb.append(top1.c);
			if(top2.count > 0)
				sb.append(top2.c);
			top1.count--;
			top2.count--;
			pq.add(top1);
			pq.add(top2);
		}

		return sb.toString();

	}

}

class CharacterCount {

	Character c;
	int count;

	CharacterCount(Character c, int count) {
		this.c = c;
		this.count = count;

	}

}
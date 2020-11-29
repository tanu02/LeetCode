package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public List<String> topKFrequent(String[] words, int k) {
		List<String> outputList = new ArrayList<>();
		if (words == null || k == 0)
			return outputList;
		Map<String, Integer> countMap = new HashMap<>();
		Queue<String> queue = new PriorityQueue<>(
				(a, b) -> countMap.get(a) - countMap.get(b)
				);

		for (int i = 0; i < words.length; i++) {
			countMap.put(words[i], countMap.getOrDefault(words[i], 0) + 1);
			if (queue.size() < k) {
				queue.add(words[i]);
			} else if (countMap.get(words[i]) > countMap.get(queue.peek())) {
				queue.poll();
				queue.add(words[i]);

			}
		}

		int size = queue.size(); 
		for(int i = 0 ; i < size; i++) {
			outputList.add(queue.poll());
		}
		Collections.reverse(outputList);
		return outputList;
	}

}

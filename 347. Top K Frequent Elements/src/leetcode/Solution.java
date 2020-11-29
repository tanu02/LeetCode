package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	public int[] topKFrequent(int[] nums, int k) {
		if (k == 0 || nums == null || nums.length == 0)
			return new int[0];

		int[] outputArr = new int[k];
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
		}

		Queue<Integer> topKQueue = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));

		for (Integer elem : frequencyMap.keySet()) {
			if (topKQueue.size() < k)
					topKQueue.offer(elem);

			else if (frequencyMap.get(elem) > frequencyMap.get(topKQueue.peek())) {
				topKQueue.poll();
				topKQueue.add(elem);
			}

		}

		for (int i = k - 1; i >= 0; i--) {
			outputArr[i] = topKQueue.poll();
		}
		return outputArr;

	}
}
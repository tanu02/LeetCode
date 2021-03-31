package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0)
            return new int[0];

        int[] outputArr = new int[k];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> topKQueue = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));

        for (Integer elem : frequencyMap.keySet()) {
            if (topKQueue.size() < k)  //keep piling till k size
                topKQueue.offer(elem);

            else if (frequencyMap.get(elem) > frequencyMap.get(topKQueue.peek())) {
                topKQueue.poll();        //current elem has to be greater than smallest elem in queue
                topKQueue.add(elem);
            }

        }

        for (int i = k - 1; i >= 0; i--) {   //queue has [0, 5, 10]
            outputArr[i] = topKQueue.poll(); //output is in descending order [10 5 0]
        }
        return outputArr;

    }
}
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> outputList = new ArrayList<>();
		if (edges == null || ((edges.length == 0 || edges[0].length == 0) && n == 0)) 
				return outputList;
		if (n == 1) {
			outputList.add(0);
			return outputList;
		}
		if (n == 2) {
			outputList.add(edges[0][0]);
			outputList.add(edges[0][1]);
			return outputList;
		}

		Map<Integer, List<Integer>> adjMap = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			adjMap.putIfAbsent(edges[i][0], new ArrayList<>());
			adjMap.putIfAbsent(edges[i][1], new ArrayList<>());
			
			adjMap.get(edges[i][0]).add(edges[i][1]);
			adjMap.get(edges[i][1]).add(edges[i][0]);
		}

		Queue<Integer> leaves = new LinkedList<>();

		adjMap.entrySet().forEach(entry -> {
			if (adjMap.get(entry.getKey()).size() == 1) {
				leaves.add(entry.getKey());
			}

			;
		});

		while (n > 2) {
			int size = leaves.size();
			for (int i = 0; i < size; i++) {
				Integer leave = leaves.poll();
				Integer parentNode = adjMap.get(leave).get(0);
				adjMap.get(parentNode).remove(leave);
				if (adjMap.get(parentNode).size() == 1)
					leaves.add(parentNode);
				n--;
			}

		}
		leaves.forEach(leave -> outputList.add(leave));
		return outputList;
	}
}

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

	Map<Integer, Integer> verticesMap = new HashMap<Integer, Integer>();
	Map<Integer, List<Integer>> adjMap = new HashMap<Integer, List<Integer>>();
	List<Integer> topoList = new ArrayList<>();

	private void initialize(int numCourses, int[][] prerequisites) {

		int parent, child;
		List<Integer> childList;

		for (int i = 0; i < prerequisites.length; i++) {
			parent = prerequisites[i][0];
			child = prerequisites[i][1];
			childList = adjMap.getOrDefault(parent, new ArrayList<>());
			childList.add(child);
			adjMap.put(parent, childList);

		}
		for (int i = 0; i < numCourses; i++) {
			if (!adjMap.containsKey(i))
				adjMap.put(i, null);
		}
		for (int i = 0; i < numCourses; i++) {
			verticesMap.put(i, 0);
		}
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		initialize(numCourses, prerequisites);

		Set<Integer> parentList = adjMap.keySet();
		boolean isCyclePresent = false;

		for (Integer parent : parentList) {

			isCyclePresent = dfs(parent);

			if (isCyclePresent)
				return new int[0];
		}

		return getTopoList(isCyclePresent, numCourses);
	}

	private boolean dfs(Integer vertex) {
		if (verticesMap.get(vertex) == 2)
			return false;
		if (verticesMap.get(vertex) == 1)
			return true;

		verticesMap.put(vertex, 1);

		List<Integer> childList = adjMap.get(vertex);
		if (childList != null) {
			for (Integer child : childList) {
				if (dfs(child))
					return true;
			}
		}
		verticesMap.put(vertex, 2);
		topoList.add(vertex);

		return false;
	}

	private int[] getTopoList(boolean isCycle, int numCourses) {
		int[] orderList;
		if (isCycle)
			orderList = new int[0];
		else {
			orderList = new int[numCourses];
			for (int i = 0; i < topoList.size(); i++) {
				orderList[i] = topoList.get(i);
			}
			for (int i = 0; i < numCourses; i++) {
				orderList[i] = topoList.get(i);
			}

		}
		return orderList;
	}
}
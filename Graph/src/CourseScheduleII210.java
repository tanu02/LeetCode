import java.util.*;
//prerequisites should not be null or of 0 size
//create adjMap
//update indegrees
//enqueue  all 0 indegree nodes
//add node in sol, count++
//reduce indegree of neighbors
//enqueue neighbors if indegree = 0
//count == numCourses return output
//return empty array

public class CourseScheduleII210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || numCourses <= 0)
            return new int[numCourses];

//graph, indegree
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int[] indegreeCount = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][0];
            int end = prerequisites[i][1]; //end depends on start

            adjMap.get(end).add(start);   //{1,0} means 1 is dependent on 0 : 0 -> 1
            indegreeCount[start]++;                                           //{1, 0}      0->1       increase indegree of 1
        }

//queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegreeCount[i] == 0)
                queue.add(i); //it is possible due to cycle queue is empty so don't rely on queue size
        }

//outputlist
        int index = 0;
        int[] output = new int[numCourses];

//logic  -> poll, add in sol, adj, --indegree, enqueue 0 indegree
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                output[index++] = node; //first update output then increment

                for (Integer elem : adjMap.get(node)) {
                    indegreeCount[elem]--;
                    if (indegreeCount[elem] == 0) queue.offer(elem);
                }
            }
        }

        return index == numCourses ? output : new int[0];
    }
}


class Main1 {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}}; // 0 1
        int[][] prerequisites1 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] arr = {};
        CourseScheduleII210 sol = new CourseScheduleII210();

        System.out.println(Arrays.toString(sol.findOrder(2, prerequisites)));
        System.out.println(Arrays.toString(sol.findOrder(4, prerequisites1)));
        System.out.println(Arrays.toString(sol.findOrder(2, arr)));
    }
}
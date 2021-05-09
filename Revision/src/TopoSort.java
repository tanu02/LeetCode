import java.util.LinkedList;
import java.util.*;

public class TopoSort {
/*
    indegree = an array indicating indegrees for each node
    neighbours = a HashMap recording neighbours of each node
    queue = []
            for i in indegree:
            if indegree[i] == 0:
            queue.append(i)

            while !queue.empty():
    node = queue.dequeue()
            for neighbour in neighbours[node]:
    indegree[neighbour] -= 1
            if indegree[neighbour] == 0:
            queue.append(neighbour)
 */
}


class CourseSchedule207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0 || prerequisites == null) return true;

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int[] indegreeCount = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];

            List<Integer> list = adjMap.getOrDefault(end, new ArrayList<>());
            list.add(start);
            adjMap.put(end, list);

            indegreeCount[start]++;                 //save dependent nodes indegree > 0

        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegreeCount[i] == 0) queue.offer(i); //retrieve those nodes which have 0 indegree
        }
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                count++;
                List<Integer> list = adjMap.get(node);

                if (list != null) {
                    for (int elem : list) {
                        indegreeCount[elem]--;
                        if (indegreeCount[elem] == 0) queue.add(elem);
                    }
                }
            }
        }
        return count == numCourses;
    }
}

//prerequisites should not be null or of 0 size
//create adjMap
//update indegrees
//enqueue  all 0 indegree nodes
//add node in sol, count++
//reduce indegree of neighbors
//enqueue neighbors if indegree = 0
//count == numCourses return output
//return empty array

class CourseScheduleII210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || numCourses <= 0)
            return new int[numCourses];

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int[] indegreeCount = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];

            List<Integer> list = adjMap.getOrDefault(end, new ArrayList<>()); //{1,0} means 1 is dependent on 0 : 0 -> 1
            list.add(start);                                                  // 0 - 1 in map
            adjMap.put(end, list);
            indegreeCount[start]++;                                           //{1, 0}      0->1       increase indegree of 1
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegreeCount[i] == 0)
                queue.add(i); //it is possible due to cycle queue is empty so don't rely on queue size
        }

        int index = 0;
        int[] output = new int[numCourses];

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                output[index++] = node; //first update output then increment

                List<Integer> list = adjMap.get(node); //hence after last loop index will be equal to length
                if (list != null) {
                    for (Integer elem : list) {
                        indegreeCount[elem]--;
                        if (indegreeCount[elem] == 0) queue.offer(elem);
                    }
                }
            }
        }
        return index == numCourses ? output : new int[0];
    }
}

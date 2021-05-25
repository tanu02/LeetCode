import java.util.*;

public class CourseSchedule207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0 || prerequisites == null) return true;

//graph, indegree
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int[] indegreeCount = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];

            adjMap.get(end).add(start);
            indegreeCount[start]++;                 //save dependent nodes indegree > 0
        }
//queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegreeCount[i] == 0) queue.offer(i); //retrieve those nodes which have 0 indegree
        }
        int count = 0;
//logic -> poll, count++, adj, --indegree, enqueue 0 indegree
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                count++;

                for (int elem : adjMap.get(node)) {
                    indegreeCount[elem]--;
                    if (indegreeCount[elem] == 0) queue.add(elem);
                }
            }
        }
        return count == numCourses;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        int[][] prerequisites1 = {{0, 0}};
        int[][] arr = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        CourseSchedule207 sol = new CourseSchedule207();
        System.out.println(sol.canFinish(2, prerequisites));
        System.out.println(sol.canFinish(2, prerequisites2));
        System.out.println(sol.canFinish(1, prerequisites1));
        System.out.println(sol.canFinish(20, arr));
    }
}
package prepare.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses < 0 || prerequisites == null) return new int[0];

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            int st = prerequisites[i][0];
            int end = prerequisites[i][1];

            map.get(end).add(st);
            degree[st]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0) queue.add(i);
        }
        int[] output = new int[numCourses];
        int ind = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            output[ind++] = node;
            for(int adj : map.get(node)){
                degree[adj]--;
                if(degree[adj] == 0) queue.add(adj);
            }
        }
        return ind == numCourses ? output : new int[0];
    }
}

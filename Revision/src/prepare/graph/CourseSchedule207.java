package prepare.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CourseSchedule207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses < 0 || prerequisites == null) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){ //independent nodes
            map.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){ //mapping
            int st = prerequisites[i][0];
            int end = prerequisites[i][1];
            map.get(end).add(st);
            degree[st]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < numCourses; i++){
            if(degree[i] == 0) q.add(i);
        }
        int count = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int adj : map.get(node)){
                degree[adj]--;
                if(degree[adj] == 0) q.add(adj);
            }
        }
        return count == numCourses ? true : false;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,1}} ;
        canFinish(2, arr);
    }
}

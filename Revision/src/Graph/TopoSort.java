package Graph;

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

//prerequisites should not be null | number of should be >= 0
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
            indegreeCount[start]++;       //{1, 0}      0->1       increase indegree of 1
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

//https://leetcode.com/problems/alien-dictionary/

class AlienDictionary269 {
    public String alienOrder(String[] words) {
        if (words == null) return "";

//graph, indegree
        Map<Character, Integer> indegreeMap = new HashMap<>();
        Map<Character, List<Character>> adjMap = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegreeMap.put(c, 0); // unique nodes in course schedule we had numCourses predefined and hence the array size
                adjMap.put(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";

            int length = Math.min(w1.length(), w2.length());  //abcd ab (prefix) will also be covered though they will not 																	generate any mapping
            for (int j = 0; j < length; j++) {

                if (w1.charAt(j) != w2.charAt(j)) {
                    adjMap.get(w1.charAt(j)).add(w2.charAt(j));// ab cd -> a != c
                    indegreeMap.put(w2.charAt(j), indegreeMap.get(w2.charAt(j)) + 1);  //update indegree of every character
                    break;
                }
            }
        }

//queue
        Queue<Character> queue = new LinkedList<>();
        for (Character c : indegreeMap.keySet()) {
            if (indegreeMap.get(c) == 0)                //fetch all the nodes whose indegree is 0
                queue.offer(c);
        }

//output string
        StringBuilder sb = new StringBuilder(); //we have to output a word

//logic -> poll, append in output, adj, --indegree, enqueue 0 indegree
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Character c = queue.poll();
                sb.append(c);

                for (Character next : adjMap.get(c)) {                       // a -> b, c or c -> b,b
                    indegreeMap.put(next, indegreeMap.get(next) - 1);        // if b has 0 indegree enqueue it
                    if (indegreeMap.get(next) == 0) queue.offer(next);
                }
            }
        }
        return sb.length() == indegreeMap.size() ? sb.toString() : "";
    }
}

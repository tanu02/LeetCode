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

            List<Integer> list = adjMap.getOrDefault(end, new ArrayList<>()); // (2, 1) means 1 -> 2 (2 will come after 1)
            list.add(start);                                                  // 1(end) -> 2(start) map
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

                if(adjMap.containsKey(node)){
                    for (int elem : adjMap.get(node)) {
                        indegreeCount[elem]--;
                        if (indegreeCount[elem] == 0) queue.add(elem);
                    }
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

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int[] indegreeCount = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];

            List<Integer> list = adjMap.getOrDefault(end, new ArrayList<>()); // (2, 1) means 1 -> 2 (2 will come after 1)
            list.add(start);                                                  // 1(end) -> 2(start) map
            adjMap.put(end, list);
            indegreeCount[start]++;                                           // 2 indegree++
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegreeCount[i] == 0)
                queue.add(i); //if there are 2 elements and there is a cycle then queue will be empty
        }                       //hence we should count how many nodes we actually processed

        int index = 0;
        int[] output = new int[numCourses];

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                output[index++] = node; //first update output then increment hence after last loop index will be equal to length

                if(adjMap.containsKey(node)) {   //
                    for (Integer elem : adjMap.get(node)) {
                        indegreeCount[elem]--;
                        if (indegreeCount[elem] == 0) queue.offer(elem);
                    }
                }
            }
        }
        return index == numCourses ? output : new int[0];
    }
}

//https://leetcode.com/problems/alien-dictionary/

class AlienDictionary269 {
    public String alienOrder(String[] words) {

//1) indegreeMap -> unique nodes
//2) adjMap
//3) Queue from indegreeMap containing 0 as indegree
//4) Dequeue character put in string builder
//5) Reduce indegree by 1 of neighbours
//6) Enqueue if indegree is 0
//7) Step 4)
        if (words == null) return "";

        Map<Character, Integer> indegreeMap = new HashMap<>();
        Map<Character, List<Character>> adjMap = new HashMap<>();

        //create indegree map with all unique nodes
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegreeMap.put(c, 0); // unique nodes
            }//in course schedule we had numCourses predefined and hence the array size
        }    //here we have to find all the unique entries

        //create adjMap and update indegree of characters
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            if(w1.length() > w2.length() && w1.startsWith(w2)) return ""; //abc ab

            int length = Math.min(w1.length(), w2.length());  //abcd ab (prefix) will also be covered though they will not 																	generate any mapping
            for (int j = 0; j < length; j++) {

                if (w1.charAt(j) != w2.charAt(j)) {
                    List<Character> list = adjMap.getOrDefault(w1.charAt(j), new ArrayList<>()); // ab cd -> a != c
                    list.add(w2.charAt(j));                                                      // a -> c
                    adjMap.put(w1.charAt(j), list);
                    indegreeMap.put(w2.charAt(j), indegreeMap.get(w2.charAt(j)) + 1);  //update indegree of every character
                    break;
                }
            }

        }

        //populate all indegree  0 characters
        Queue<Character> queue = new LinkedList<>();
        for (Character c : indegreeMap.keySet()) {
            if (indegreeMap.get(c) == 0)                //fetch all the nodes whose indegree is 0
                queue.offer(c);
        }

        StringBuilder sb = new StringBuilder(); //we have to output a word

        //poll indegree = 0 characters and append in the output
        //explore its dependents
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Character c = queue.poll();
                sb.append(c);                                                    //a
                if (adjMap.containsKey(c)) {
                    for (Character next : adjMap.get(c)) {                       // a -> b, c or c -> b,b
                        indegreeMap.put(next, indegreeMap.get(next) - 1);        // if b has 0 indegree enqueue it
                        if (indegreeMap.get(next) == 0) queue.offer(next);
                    }
                }
            }
        }
        return sb.length() == indegreeMap.size() ? sb.toString() : "";
    }
}



import java.util.*;
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
            if(w1.length() > w2.length() && w1.startsWith(w2)) return "";

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


class Main3 {
    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String[] words1 = {"abc"};
        String[] words2 = {};
        String[] words3 = {"z","x","z"};//empty
        String[] words4 = {"z","x"};

        String[] words5 = {"ac","ab","zc","zb"};
        String[] words6 = {"t", "t"};


        String[] words7 =     {"abc","ab"};
        AlienDictionary269 sol = new AlienDictionary269();
        System.out.println(sol.alienOrder(words));
        System.out.println(sol.alienOrder(words1));
        System.out.println(sol.alienOrder(words2));
        System.out.println(sol.alienOrder(words3));
        System.out.println(sol.alienOrder(words4));
        System.out.println(sol.alienOrder(words5));
        System.out.println(sol.alienOrder(words6));
        System.out.println(sol.alienOrder(words7));
    }
}
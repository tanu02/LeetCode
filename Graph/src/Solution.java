//332. Reconstruct Itinerary
//https://leetcode.com/problems/reconstruct-itinerary/

import java.util.*;

//Euler path
class Solution {
    List<String> output;
    Map<String, Queue<String>> adjMap;

    public List<String> findItinerary(List<List<String>> tickets) {

//graph
        adjMap = new HashMap<>();
        output = new ArrayList<>();

        for (List<String> edge : tickets) {
            String from = edge.get(0);
            String to = edge.get(1);

            Queue<String> queue = adjMap.getOrDefault(from, new PriorityQueue<>());
            queue.add(to);
            adjMap.put(from, queue);
            adjMap.put(to, adjMap.getOrDefault(to, new PriorityQueue<>()));
        }

        dfs("JFK");
        return output;
    }

    private void dfs(String node) {

        output.add(node);
        while (!adjMap.get(node).isEmpty()) {
            String next = adjMap.get(node).poll();
            dfs(next);
        }
    }
}

class Mainp {
    public static void main(String[] args) {
        Solution sol = new Solution();
//
//        String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
//        List<List<String>> list = new ArrayList<>();
//        for (String[] ticket : tickets) {
//            list.add(Arrays.asList(ticket));
//        }
//        System.out.println(sol.findItinerary(list));//["JFK","MUC","LHR","SFO","SJC"]
//
//
//        List<List<String>> list1 = new ArrayList<>();
//        String[][] tickets1 = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL","SFO"}};
//        for (String[] ticket : tickets1) {
//            list1.add(Arrays.asList(ticket));
//        }
//
//        System.out.println(sol.findItinerary(list1));//["JFK","ATL","JFK","SFO","ATL","SFO"]

        List<List<String>> list2 = new ArrayList<>();
        List<List<String>> list3 = new ArrayList<>();
        String[][] tickets2 =   {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        String[][] tickets3 =   {{"JFK","NRT"},{"JFK","KUL"},{"KUL","JFK"}};
        for (String[] ticket : tickets2) {
            list2.add(Arrays.asList(ticket));
        }
        for (String[] ticket : tickets3) {
            list3.add(Arrays.asList(ticket));
        }
        Solution1 s1 = new Solution1();
     //   System.out.println(s1.findItinerary(list2));//["JFK","NRT","JFK","KUL"]
        System.out.println(s1.findItinerary(list3));//["JFK","NRT","JFK","KUL"]
    }
}

class Solution1 {
    // origin -> list of destinations
    HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
    LinkedList<String> result = null;

    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1). build the graph first
        for(List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (this.flightMap.containsKey(origin)) {
                LinkedList<String> destList = this.flightMap.get(origin);
                destList.add(dest);
            } else {
                LinkedList<String> destList = new LinkedList<String>();
                destList.add(dest);
                this.flightMap.put(origin, destList);
            }
        }

        // Step 2). order the destinations
        this.flightMap.forEach((key, value) -> Collections.sort(value));

        this.result = new LinkedList<String>();
        // Step 3). post-order DFS
        this.DFS("JFK");
        return this.result;
    }

    protected void DFS(String origin) {
        // Visit all the outgoing edges first.
        if (this.flightMap.containsKey(origin)) {
            LinkedList<String> destList = this.flightMap.get(origin);
            while (!destList.isEmpty()) {
                // while we visit the edge, we trim it off from graph.
                String dest = destList.pollFirst();
                DFS(dest);
            }
        }
        // add the airport to the head of the itinerary
        this.result.offerFirst(origin);
    }
}
import java.util.*;
import java.util.PriorityQueue;

public class Dijkstra {
}


//743. Network Delay Time
//
//https://leetcode.com/problems/network-delay-time/
// times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2

class NetworkDelayTime743 {

    public int networkDelayTime(int[][] times, int n, int k) {
//graph, distance - hashmap
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        Map<Integer, Integer> distance = new HashMap<>();
        for (int i = 1; i <= n; i++) { //however many nodes are there add them
            adjMap.put(i, new ArrayList<>()); //verify starting node is 0 or 1
            distance.put(i, Integer.MAX_VALUE);
        }
        for (int[] edge : times) {
            adjMap.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

//priority queue
        Queue<Node> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.weight, n2.weight));
        queue.add(new Node(k, 0)); //source node;

//visited set
        Set<Integer> visitedSet = new HashSet<>();
//nodes count
        int count = 0;

//logic
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visitedSet.contains(node.val)) continue; //if already visited do not process

            visitedSet.add(node.val);
            count++;

            if (count == n) return node.weight; //last node
            //update adj nodes
            List<int[]> adjList = adjMap.get(node.val);

            for (int[] edge : adjList) { //process adj edge
                int to = edge[0];
                int newDist = node.weight + edge[1];

                if (visitedSet.contains(to)) continue; //already visited

                if (newDist < distance.get(to)) { // distance is less than what exists
                    distance.put(to, newDist);
                    queue.offer(new Node(to, newDist));
                }
            }
        }
        return -1;
    }
    class Node {
        int val;
        int weight;

        Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }
}


//https://leetcode.com/problems/cheapest-flights-within-k-stops/
//787. Cheapest Flights Within K Stops
class CheapestFlightsWithinKStops787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

//graph, distance, stops - hashmap
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        Map<Integer, Integer> distanceMap = new HashMap<>();
        Map<Integer, Integer> stopsMap = new HashMap<>();

        for (int i = 0; i < n; i++) { // nodes are from 0 -> n-1
            adjMap.put(i, new ArrayList<>());
            distanceMap.put(i, Integer.MAX_VALUE);
            stopsMap.put(i, Integer.MAX_VALUE);
        }
        distanceMap.put(src, 0);
        stopsMap.put(src, 0);

        for (int[] flight : flights) {
            adjMap.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

//priority queue
        Queue<Node1> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.distance, n2.distance));
        queue.offer(new Node1(src, 0, 0));

//logic
        while (!queue.isEmpty()) {
            Node1 node = queue.poll();
            int from = node.val;
            int currDis = node.distance;
            int currStops = node.stops;

            if (node.val == dst) return node.distance; // valid min entry

            if (node.stops == k + 1) continue;

            for (int[] adj : adjMap.get(from)) {
                int to = adj[0];
                int newDist = currDis + adj[1];

                if (newDist < distanceMap.get(to) || currStops + 1 < stopsMap.get(to)) {
                    queue.offer(new Node1(to, newDist, currStops + 1));
                    distanceMap.put(to, newDist);
                    stopsMap.put(to, currDis + 1);
                }
            }
        }
        return -1;

    }

    class Node1 {
        int val;
        int distance;
        int stops;

        public Node1(int val, int distance, int stops) {
            this.val = val;
            this.distance = distance;
            this.stops = stops;
        }

    }

}

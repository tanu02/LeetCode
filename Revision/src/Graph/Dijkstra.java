package Graph;

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

//logic -> poll, if visited, visit, if dst, adj
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

                if (visitedSet.contains(to)) continue;  //can check visit as it is just an int unlike other q either a node  is present or a cell

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

//logic -> poll, if dst, if stops k+1, adj
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

class PathWithMinimumEffort1631 {
    int[] rows = {0, 0, 1, -1};
    int[] cols = {1, -1, 0, 0};

    public int minimumEffortPath(int[][] heights) {
        if (heights == null || heights.length == 0) return -1;

//queue comparator
        Queue<Node> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.eff, n2.eff));
        queue.offer(new Node(new int[]{0, 0}, 0));
//visited
        Set<Node> visited = new HashSet<>();
//efforts
        int[][] effort = new int[heights.length][heights[0].length];
        for (int[] arr : effort) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

//logic - > poll, if visited, visit, if dst, adj, enqueue
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int r = node.loc[0];
            int c = node.loc[1];
            int currEff = node.eff;

            if (r == heights.length - 1 && c == heights[0].length - 1) return currEff;
            if (visited.contains(node)) continue;
            visited.add(node);

            for (int i = 0; i < rows.length; i++) {
                int rr = r + rows[i];
                int cc = c + cols[i];
                if (!isValid(rr, cc, heights)) continue;

                int edge = Math.abs(heights[rr][cc] - heights[r][c]);
                int eff = Math.max(currEff, edge);

                if (eff < effort[rr][cc]) {
                    queue.offer(new Node(new int[]{rr, cc}, eff));
                    effort[rr][cc] = eff;
                }
            }
        }

        return -1;
    }

    private boolean isValid(int row, int col, int[][] heights) {
        if (row < 0 || row == heights.length || col < 0 || col == heights[0].length) return false;
        return true;
    }

    class Node {
        int[] loc;
        int eff;

        Node(int[] loc, int eff) {
            this.loc = loc;
            this.eff = eff;
        }
    }

}

//to reach dst there are multiple paths
//we have to float max edge in any path
//now there can be multiple paths so the one which has min edge is the ans
//Example uber  driver has  2  paths
// 1st has 2 stops  15min (a) and 1hr(b) so this  path will have  1 hr as  final effort
// 2nd has 2 stops  30 min(a) and 30min(b) this path will have 30 min as final effort



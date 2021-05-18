import java.util.*;

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

class Main0 {
    public static void main(String[] args) {
        CheapestFlightsWithinKStops787 sol = new CheapestFlightsWithinKStops787();
        int n = 3, src = 0, dst = 2, k = 1;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};

        int n1 = 3, src1 = 0, dst1 = 2, k1 = 0;

        System.out.println(sol.findCheapestPrice(n, flights, src, dst, k));//200
        System.out.println(sol.findCheapestPrice(n1, flights, src1, dst1, k1));//500

        int[][] flights1 = {{0, 1, 100}, {1, 0, 100}};
        System.out.println(sol.findCheapestPrice(n1, flights1, src1, dst1, k));//-1

        int n2 = 3, src2 = 1, dst2 = 2, k2 = 1;
        int[][] flights2 = {{0, 1, 2}, {1, 2, 1}, {2, 0, 10}};
        System.out.println(sol.findCheapestPrice(n2, flights2, src2, dst2, k2));

        int n3 = 11, src3 = 0, dst3 = 2, k3 = 4;
        int[][] flights3 = {{0, 3, 3}, {3, 4, 3}, {4, 1, 3}, {0, 5, 1}, {5, 1, 100}, {0, 6, 2}, {6, 1, 100}, {0, 7, 1}, {7, 8, 1}, {8, 9, 1}, {9, 1, 1}, {1, 10, 1}, {10, 2, 1}, {1, 2, 100}};
        CheapestFlightsWithinKStops787 sol1 = new CheapestFlightsWithinKStops787();

        int n4 = 11, src4 = 0, dst4 = 8, k4 = 3;
        int[][] flights4 = {{0, 1, 1}, {1,2,1}, {2, 3, 1},{3, 4,1}, {0, 5, 4}, {5, 4, 10}, {0, 6, 5}, {6, 7, 3}, {7, 4, 1}, {4, 8, 1}};
        System.out.println(sol.findCheapestPrice(n4, flights4, src4, dst4, k4));
    }
}

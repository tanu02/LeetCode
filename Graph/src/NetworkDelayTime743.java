import java.util.*;

//743. Network Delay Time
//
//https://leetcode.com/problems/network-delay-time/
// times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2

public class NetworkDelayTime743 {

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



class Main7 {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;

        int[][] times1 = {{1, 2, 1}};
        int n1 = 2, k1 = 1;
        int[][] times2 = {{1, 2, 1}};
        int n2 = 2, k2 = 2;
        NetworkDelayTime743 sol = new NetworkDelayTime743();
        System.out.println(sol.networkDelayTime(times, n, k)); //2
        System.out.println(sol.networkDelayTime(times1, n1, k1));//1
        System.out.println(sol.networkDelayTime(times1, n2, k2));//1
    }
}

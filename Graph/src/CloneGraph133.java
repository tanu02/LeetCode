//133. Clone Graph
//https://leetcode.com/problems/clone-graph/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CloneGraph133 {
    Map<Node, Node> cloneMap;

    public Node cloneGraph(Node node) {
        cloneMap = new HashMap<>();
        if (node == null) return null;
        return dfs(node);
    }

    private Node dfs(Node node) {

        if (cloneMap.containsKey(node)) return cloneMap.get(node);
        Node node1 = new Node(node.val, new ArrayList<>());
        cloneMap.put(node, node1);

        for (Node next : node.neighbors) {
            node1.neighbors.add(dfs(next));  //every state returns its clones value
        }
        return node1;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }
}



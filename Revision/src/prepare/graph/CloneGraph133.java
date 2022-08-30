package prepare.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph133 {
    private Map<Node, Node> visited;

    public Node cloneGraph(Node node) {
        visited = new HashMap<>();

        return clone(node);
    }

    private Node clone(Node node) {
        if (node == null) {
            return null;
        }
        if(visited.containsKey(node)) return visited.get(node);

        Node newNode = new Node(node.val, new ArrayList<>());
        visited.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor));
        }

        return newNode;
    }
}


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
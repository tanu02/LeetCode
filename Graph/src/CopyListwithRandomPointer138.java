//138. Copy List with Random Pointer
//https://leetcode.com/problems/copy-list-with-random-pointer/

import java.util.HashMap;
import java.util.Map;

class CopyListwithRandomPointer138 {
    Map<Node, Node> cloneMap;

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        cloneMap = new HashMap<>();
        return dfs(head);
    }

    private Node dfs(Node node) {

        if (node == null) return null;

        if (cloneMap.containsKey(node)) return cloneMap.get(node);

        Node node1 = new Node(node.val);
        cloneMap.put(node, node1);

        node1.next = dfs(node.next);
        node1.random = dfs(node.random);

        return node1;

    }

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


}

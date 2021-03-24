class DesignDoublyLinkedList {
    Node head;
    Node tail;
    int size;

    /**
     * Initialize your data structure here.
     */
    public DesignDoublyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Get the value of the index-th node in the linked list    . If the index is invalid, return -1.
     */
    public int get(int index) {

        if (index < 0 || index >= size) return -1;
        Node prev = head;

        for (int i = 0; i < index + 1; i++) prev = prev.next;

        return prev.val;

    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        //here we have to add a node before given
        // index so size is a valid index because we will be adding just before that
        if (index < 0 || index > size) return;
        Node current = head;
        for (int i = 0; i < index + 1; i++) { //doubly so reach till that index. if index is size then loop till tail
            current = current.next;

        }
        Node prevNode = current.prev; //get prevNode unlike singly get nextNode;
        Node node = new Node(val);

        node.next = current;
        current.prev = node;
        prevNode.next = node;
        node.prev = prevNode;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) { //here we have to delete ith node which has to be within 0 and size -1 
        if (index < 0 || index >= size) return;
        Node current = head;
        for (int i = 0; i < index + 1; i++) current = current.next;

        Node nextNode = current.next;
        Node prevNode = current.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }

    public int getSize() {
        return size;
    }
}

class Solution1 {
    public static void main(String args []) {
        DesignDoublyLinkedList myLinkedList = new DesignDoublyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3

        System.out.println("added elements ");
        print(myLinkedList);

        System.out.println("expected 2 " + myLinkedList.get(1));              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        System.out.println("after deletion ");
        print(myLinkedList);
        System.out.println("expected 3 " + myLinkedList.get(1));              // return 3
    }

    private static void print(DesignDoublyLinkedList head) {
        int size = head.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(head.get(i));
        }
    }

}




class DesignSingleLinkedList {

    int size;
    Node head;

    /**
     * Initialize your data structure here.
     */
    public DesignSingleLinkedList() {
        head = new Node();
        size = 0;

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        Node prev = head;
        for (int i = 0; i < index + 1; i++) {
            prev = prev.next;
        }
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
     * Add a node of value val before the index-th node in the linked list. If index equals to the size of linked list, the node will be appended to the end of linked list. If index is greater than the size, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;  //just before size is a valid index

        Node prev = head;
        for (int i = 0; i < index; i++) { //reach index-1 to add after it
            prev = prev.next;                  //0 -> index -1 + 1 (index -1 for prev index +1 for sentinel)
        }
        Node node = new Node(val);
        node.next = prev.next;
        prev.next = node;
        size++;

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
        size--;
    }

    public int getSize() {
        return size;
    }
}

class Solution2 {
    public static void main(String args []) {
        DesignSingleLinkedList myLinkedList = new DesignSingleLinkedList();
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

    private static void print(DesignSingleLinkedList head) {
        int size = head.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(head.get(i));
        }
    }

}


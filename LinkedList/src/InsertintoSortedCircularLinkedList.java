


class InsertintoSortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node =  new Node(insertVal);
            node.next = node;
            return node;
        }

        Node current = head;

        while (current.next != head) {

            Node nextNode = current.next;

            if (current.val <= nextNode.val
                    && current.val <= insertVal && insertVal <= nextNode.val) { //upward ladder
                addAfter(current, insertVal);
                return head;
            } else if (current.val > nextNode.val) {
                if (insertVal >= current.val || insertVal <= nextNode.val) {
                    addAfter(current, insertVal);
                    return head;
                }
            }
            current = current.next;
        }

        addAfter(current, insertVal);
        return head;
    }

    private void addAfter(Node current, int insertVal) {

        Node newNode = new Node(insertVal);
        Node nextNode = current.next;

        current.next = newNode;
        newNode.next = nextNode;
    }
}


class Solution3 {
    public static void main(String args[]) {
        InsertintoSortedCircularLinkedList myLinkedList = new InsertintoSortedCircularLinkedList();

        Node three = new Node(3);
        Node five = new Node(5);
        Node seven = new Node(7);
        Node nine = new Node(9);
        Node one = new Node(1);

        three.next = five;
        five.next = seven;
        seven.next = nine;
        nine.next = one;
        one.next = three;

        Node same = new Node(3);
        Node same2 = new Node(3);
        Node same3 = new Node(4);
        Node same4 = new Node(3);
        Node same5 = new Node(3);

        same.next = same2;
        same2.next = same3;
        same3.next = same4;
        same4.next = same5;
        same5.next = same;


        print(myLinkedList.insert(three, 10));
        print(myLinkedList.insert(three, 0));
        print(myLinkedList.insert(three, 10));
        print(myLinkedList.insert(same, 3));
        print(myLinkedList.insert(same, 2));
        print(myLinkedList.insert(null, 1));
    }

    private static void print(Node head) {

        Node current = head;
        while (current.next != head && current.next != null) {
            System.out.print(current.val + "\t");
            current = current.next;
        }
        System.out.println(current.val);
    }
}





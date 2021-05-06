public class LinkedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode current = new ListNode();  //tracking pointer
        ListNode head = current;

        while (l1 != null && l2 != null) {  // if both are null mean no elements in any list : return null as answer
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;

        }

        current.next = l1 == null ? l2 : l1;

        return head.next;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //the only thing we are trying to achieve is to place both the nodes at a location
        // from where their remaining list is of equal size.

        // or I should say both should traverse equal distance.
        // If a has a leap of 2 nodes make it move 2 nodes in b’s list 
        if (headA == null || headB == null) return null; // if 1 list does not exist return
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) { //after one rotation if they intersect - next element will be the intersection or they will meet at null
            if (p1.next == null && p2.next == null) return null;  // if there is no common point
            p1 = p1.next == null ? headB : p1.next;
            p2 = p2.next == null ? headA : p2.next;

        }
        return p1;

    }
 //1)
     //p1        3 4 5     intersection is 4
    // p2    1 2 6 4 5          p1   3 4 5 1 2 6 4
//                              p2   1 2 6 4 5 3 4
//note how p1 and p2 traverse same distance until they reach 4
// 2)
    //had there been no intersection
      //p1         3 7 4
      // p2    1 2 6 8 5
//still p1 and p2 traverse same distance
// p1           3 7 4 1 2 6 8 5 null
//pw            1 2 6 8 5 3 7 4 null

//3)
       // 1 2 3 null
      //  4 5 6 null
    //intersection is null p1 1 2 3 null
    //                     p2 4 5 6 null

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int carry = 0;
        ListNode head = new ListNode();
        ListNode l3 = head;

        while (l1 != null || l2 != null || carry != 0) {
            //any of these exist keep summing

            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carry;

            l3.next = new ListNode(sum % 10);
            l3 = l3.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            if (sum >= 10) carry = 1;
            else carry = 0;
        }
        return head.next;
    }
}

class InsertintoSortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node current = head; // use case : 3 3, 3 5 or 5 1

        while (current.next != head) { //singly ll we insert after a given node so reach till the last node

            Node nextNode = current.next;

            if (current.val <= nextNode.val && current.val <= insertVal && insertVal <= nextNode.val) { //upward ladder
                addAfter(current, insertVal); // 3 5 or 3 3
                return head;
            } else if (current.val > nextNode.val) { // 5 1 rotated point
                if (insertVal >= current.val || insertVal <= nextNode.val) { //either 5>= or 1<= can be inserted
                    addAfter(current, insertVal);
                    return head;
                }
            }
            current = current.next;
        }

        addAfter(current, insertVal); //reached the last node, insert after it
        return head;
    }

    private void addAfter(Node current, int insertVal) {

        Node newNode = new Node(insertVal);
        Node nextNode = current.next;

        current.next = newNode;
        newNode.next = nextNode;
    }
}

class PalindromeLinkedList {
    ListNode listHead;

    public boolean isPalindrome(ListNode head) {
        listHead = head;
        return checkPalindrome(head);
    }

    private boolean checkPalindrome(ListNode node) {
        if (node == null) return true;

        if (!checkPalindrome(node.next)) return false;  //inner branch found mismatch
        if (node.val != listHead.val) return false; //current node found mismatch

        listHead = listHead.next;

        return true;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Node {
    public int val;
    public Node next;
    public Node prev;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionofTwoLinkedLists {
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
}
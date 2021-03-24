/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//https://leetcode.com/problems/merge-two-sorted-lists/solution/
class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


			ListNode current = new ListNode();  //tracking pointer
			ListNode head = current; 
			
			while(l1 != null && l2 != null){  // if both are null mean no elements in any list : return null as answer 
					if (l1.val <= l2.val){
								current.next = l1; 
								l1 = l1.next; 
						} else{
								current.next = l2; 
								l2 = l2.next; 
							}
				current = current.next; 
		
			}
			
		current.next = l1 == null ? l2 : l1;

		return head.next;  

	}
}


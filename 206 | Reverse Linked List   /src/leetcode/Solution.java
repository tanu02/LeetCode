package leetcode;

class Solution {
 
	public ListNode reverseList(ListNode head) {
		
     return reverse(null, head);   
    }
	
	private ListNode reverse(ListNode prev, ListNode curr) {
		if(curr == null) return prev;
		
		ListNode next = curr.next;
		curr.next = prev; 
		return reverse(curr, next);
	}
}
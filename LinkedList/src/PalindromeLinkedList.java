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
//https://leetcode.com/problems/palindrome-linked-list/
class PalindromeLinkedList {
	ListNode listHead; 
    public boolean isPalindrome(ListNode head) {
			listHead = head; 
			return checkPalindrome(head); 
    }

	private boolean checkPalindrome(ListNode node){
			if(node == null) return true; 
        
			if(!checkPalindrome(node.next)) return false;  //inner branch found mismatch 
			if(node.val != listHead.val) return false; //current node found mismatch 
        
		listHead = listHead.next;
				
		return true;  
		
}
}
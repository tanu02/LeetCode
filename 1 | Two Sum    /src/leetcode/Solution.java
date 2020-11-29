package leetcode;

class Solution {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode vHead = new ListNode(0);
		ListNode curr = vHead;
		
		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}

		curr.next = l1 == null ? l2 : l1; 

		return vHead.next;
	}
}
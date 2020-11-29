package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = null;
		ListNode newHead = sol.reverseList(head);

		while(newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}

}

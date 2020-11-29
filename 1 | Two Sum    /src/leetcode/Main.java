package leetcode;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		n2.next = null;
		ListNode m1 = new ListNode(1);
		ListNode m2 = new ListNode(3);

		m1.next = m2;
		m2.next = null;

		ListNode node = sol.mergeTwoLists(n1, m1);
		
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

}

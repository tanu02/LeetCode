

public class AddTwoNumbers {
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode head = new ListNode();
        ListNode l3 = head;

        while (l1 != null || l2 != null || carry != 0) {
            //any of these exist keep summing
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            l3.next = new ListNode(sum % 10);
            l3 = l3.next;

            if (sum >= 10) carry = 1;
            else carry = 0;
        }
        return head.next;
    }
}


class Solution4 {
    public static void main(String args[]) {
        //[9,9,9,9,9,9,9]
        //[9,9,9,9]
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode a1 = new ListNode(9);
        ListNode a2 = new ListNode(9);
        ListNode a3 = new ListNode(9);
        ListNode a4 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        AddTwoNumbers sol = new AddTwoNumbers();
        ListNode l4 = sol.addTwoNumbers(n1, n2);
        while (l4 != null) {
            System.out.print(l4.val + '\t');
            l4 = l4.next;
        }
    }
}
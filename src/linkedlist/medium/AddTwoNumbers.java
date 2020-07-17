package linkedlist.medium;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        int carry = 0;
        ListNode head = null;
        ListNode tail = null;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;

            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;

            l2 = l2.next;
        }

        if(carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }

        return head;
    }
}

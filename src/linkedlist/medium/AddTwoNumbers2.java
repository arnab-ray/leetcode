package linkedlist.medium;

public class AddTwoNumbers2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }

    private ListNode additionUtil(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        int carry = 0;
        ListNode head = null;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverseLL(l1);
        ListNode head2 = reverseLL(l2);

        ListNode resultHead = additionUtil(head1, head2);

        return resultHead;
    }

}

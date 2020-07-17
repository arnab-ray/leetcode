package linkedlist.medium;

public class ReorderLL {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }

    private ListNode reverseList(ListNode head) {
        if(head != null) {
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
        }

        return head;
    }

    private ListNode mergeLists(ListNode head1, ListNode head2) {
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

        ListNode head = head1;
        ListNode temp = head;
        head1 = head1.next;

        while (head1 != null || head2 != null) {
            if(head2 != null) {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
            if(head1 != null) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }
        }

        return head;
    }

    public void reorderList(ListNode head) {
        if(head != null) {
            ListNode middle = getMiddleNode(head);
            ListNode anotherHead = reverseList(middle.next);
            middle.next = null;
            head = mergeLists(head, anotherHead);
        }
    }
}

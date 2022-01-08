package linkedlist.medium;

/**
 * @author arnab.ray
 * @created on 08/01/22
 */
// #2095
public class DeleteMiddleNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slowPtr = head, fastPtr = head, prevPtr = null;
        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        prevPtr.next = slowPtr.next;
        return head;
    }
}

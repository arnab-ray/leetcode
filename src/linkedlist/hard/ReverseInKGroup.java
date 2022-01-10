package linkedlist.hard;

/**
 * @author arnab.ray
 * @created on 10/01/22
 */
// #25
public class ReverseInKGroup {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private int getSize(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    private ListNode reverseKGroupUtil(ListNode head, int k, int remaining) {
        if (head == null || k > remaining)
            return head;

        int counter = 0;
        ListNode prev = null, current = head, next = null;
        while (current != null && counter++ < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (next != null)
            head.next = reverseKGroupUtil(next, k, remaining - k);

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int size = getSize(head);
        return reverseKGroupUtil(head, k, size);
    }
}

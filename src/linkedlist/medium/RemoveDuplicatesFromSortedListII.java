package linkedlist.medium;

import java.util.List;

public class RemoveDuplicatesFromSortedListII {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dup = new ListNode();
        dup.next = head;
        ListNode curr = dup;

        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int duplicateValue = curr.next.val;
                while (curr.next != null && curr.next.val == duplicateValue) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }

        return dup.next;
    }
}

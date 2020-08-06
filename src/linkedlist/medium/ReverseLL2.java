package linkedlist.medium;

public class ReverseLL2 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // [1,2,3,4,5] [2,4]
    // [3,5] [1,2]
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        for(int i = 0; i < m - 1; i++)
            temp = temp.next;

        ListNode prev = temp;
        ListNode tail = temp.next;

        int count = n - m;
        while (count-- > 0) {
            ListNode temp_ = prev.next;
            prev.next = tail.next;
            tail.next = tail.next.next;
            prev.next.next = temp_;
        }

        return dummy.next;
    }
}

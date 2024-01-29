package linkedlist.medium;

public class ReverseLL2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // [1,2,3,4,5] [2,4]
    // [3,5] [1,2]
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right)
            return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;
        for(int i = 0; i < left - 1; i++)
            temp = temp.next;

        ListNode prev = temp;
        ListNode curr = temp.next;
        ListNode next = null;

        for (int i = 0; i < right - left + 1; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        temp.next.next = curr;
        temp.next = prev;

        return dummy.next;
    }
}

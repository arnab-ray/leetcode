package linkedlist.medium;

public class SwapNodeInPairs {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tail = swapPairs(head.next.next);

        ListNode temp = head;
        head = head.next;
        head.next = temp;
        temp.next = tail;

        return head;
    }
}

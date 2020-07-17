package linkedlist.medium;

public class ReverseLL2 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode reverseUtil(ListNode head, int n) {
        if(head != null) {
            int k = 0;
            ListNode prev = null;
            ListNode current = head;
            ListNode next;

            while (k < n && current != null) {
                k++;
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            head.next = current;
            head = prev;
        }

        return head;
    }

    // [1,2,3,4,5] [2,4]
    // [3,5] [1,2]
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n)
            return head;

        ListNode temp = head;
        for(int i = 1; i < m - 1 && temp != null; i++)
            temp = temp.next;

        ListNode dummyHead = temp;
        temp = reverseUtil(temp, n - m - 1);
        return dummyHead == head ? temp : head;
    }
}

package linkedlist.medium;

public class RotateLL {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private int getSize(ListNode head) {
        ListNode temp = head;
        int count = 0;
        for(; temp != null; temp = temp.next)
            count++;

        return count;
    }

    private ListNode getTailList(ListNode head, int n) {
        int i = 0;
        ListNode temp = head;
        while(i < n - 1) {
            temp = temp.next;
            i++;
        }

        ListNode anotherHead = temp.next;
        temp.next = null;

        return anotherHead;
    }

    private ListNode appendList(ListNode head1, ListNode head2) {
        if(head1 != null) {
            ListNode temp = head1;
            while (temp.next != null)
                temp = temp.next;

            temp.next = head2;
            return head1;
        }

        return head2;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head != null) {
            int size = getSize(head);
            int num = k >= size ? Math.abs(size - k) % size : k;
            ListNode anotherHead = getTailList(head, size - num);
            head = appendList(anotherHead, head);
        }

        return head;
    }
}

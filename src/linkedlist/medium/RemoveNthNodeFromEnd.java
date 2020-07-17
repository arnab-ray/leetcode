package linkedlist.medium;

public class RemoveNthNodeFromEnd {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private int getSize(ListNode head) {
        int k = 0;
        ListNode node = head;
        while (node != null) {
            k++;
            node = node.next;
        }

        return k;
    }

    private ListNode findNode(ListNode head, int i) {
        int k = 1;
        ListNode temp = head;
        while(temp != null) {
            k++;
            if(k == i)
                return temp;
            temp = temp.next;
        }

        return null;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        int size = getSize(head);
        if(size == n) {
            head = head.next;
        } else {
            ListNode node = findNode(head, size - (n - 1));
            if(node != null)
                node.next = node.next.next;
        }
        return head;
    }
}

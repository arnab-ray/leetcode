package linkedlist.medium;

/**
 * @author arnab.ray
 * @created on 08/01/22
 */
// #1721
public class SwappingNodesLL {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode fastPtr = head, slowPtr = head;
        for (int i = 1; i < k; i++)
            fastPtr = fastPtr.next;

        ListNode first = fastPtr;

        while (fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        if (slowPtr != null) {
            int temp = first.val;
            first.val = slowPtr.val;
            slowPtr.val = temp;
        }

        return head;
    }
}

package linkedlist.easy;

public class DeleteNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node = node.next;
        }

        node.val = node.next.val;
        node.next = null;
    }
}

package linkedlist.easy;

public class PalindromeLL {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private int getSize(ListNode head) {
        ListNode temp = head;
        int k = 0;
        while (temp != null) {
            k++;
            temp = temp.next;
        }

        return k;
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }

    private ListNode reverseLL(ListNode head) {
        if(head != null) {
            ListNode prevHead = null;
            ListNode currentHead = head;
            ListNode nextHead;

            while (currentHead != null) {
                nextHead = currentHead.next;
                currentHead.next = prevHead;
                prevHead = currentHead;
                currentHead = nextHead;
            }

            head = prevHead;
            return head;
        }

        return null;
    }

    private boolean isPalindromeUtil(ListNode head1, ListNode head2) {
        while (head2 != null) {
            if(head1.val != head2.val)
                return false;

            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }



    public boolean isPalindrome(ListNode head) {
        int size = getSize(head);
        if(size == 1)
            return true;

        ListNode middleNode = getMiddleNode(head);
        ListNode secondHead = size % 2 == 0 ? reverseLL(middleNode) : reverseLL(middleNode.next);
        return size % 2 == 0 ? isPalindromeUtil(head, secondHead) : isPalindromeUtil(head, secondHead);
    }
}

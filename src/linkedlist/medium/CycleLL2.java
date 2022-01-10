package linkedlist.medium;

/**
 * @author arnab.ray
 * @created on 10/01/22
 */
// #142
public class CycleLL2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode slowPtr = head, fastPtr = head;
        boolean flag = false;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                flag = true;
                break;
            }
        }

        fastPtr = head;
        if (flag) {
            while (fastPtr != slowPtr) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            return slowPtr;
        }
        return null;
    }
}

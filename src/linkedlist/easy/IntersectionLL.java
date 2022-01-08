package linkedlist.easy;

/**
 * @author arnab.ray
 * @created on 08/01/22
 */
// #160
public class IntersectionLL {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private int getSize(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        int diff = Math.abs(sizeA - sizeB);
        ListNode fastPtr, slowPtr;

        if (sizeA > sizeB) {
            fastPtr = headA;
            slowPtr = headB;
        } else {
            fastPtr = headB;
            slowPtr = headA;
        }

        for (int i = 0; i < diff; i++)
            fastPtr = fastPtr.next;

        while (fastPtr != null && slowPtr != null) {
            if (fastPtr == slowPtr)
                return fastPtr;

            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }

        return null;
    }
}

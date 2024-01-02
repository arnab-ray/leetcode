package linkedlist.easy;

public class RemoveDuplicatesFromSortedList {
     static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode deleteDuplicates(ListNode head) {
         if (head == null) return null;

         ListNode curr = head;

        while (curr.next != null) {
             if (curr.val == curr.next.val) {
                 curr.next = curr.next.next;
             } else {
                 curr = curr.next;
             }
         }

         return head;
    }
}
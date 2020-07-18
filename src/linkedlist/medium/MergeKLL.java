package linkedlist.medium;

public class MergeKLL {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private int findMin(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val <= min) {
                min = lists[i].val;
                index = i;
            }
        }

        return index;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;

        ListNode head = new ListNode(-1);
        ListNode dummyHead = head;

        while(true) {
            int listNum = findMin(lists);
            System.out.println(listNum);
            if(listNum != -1) {
                dummyHead.next = lists[listNum];
                dummyHead = dummyHead.next;
                lists[listNum] = lists[listNum].next;
            } else {
                break;
            }
        }

        return head.next;
    }
}

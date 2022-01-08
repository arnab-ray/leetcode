package linkedlist.medium;

public class CopyListRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null)
            return null;

        Node current = head, temp;

        // insert copy of node after each node
        while (current != null) {
            temp = current.next;
            current.next = new Node(current.val);
            current.next.next = temp;
            current = temp;
        }

        current = head;
        while (current != null) {
            if (current.next != null) {
                current.next.random = current.random != null ? current.random.next : null;
            }
            current = current.next != null ? current.next.next : null;
        }

        Node original = head, copy = head.next;
        temp = copy;
        while (original != null && copy != null) {
            original.next = original.next != null ? original.next.next : null;
            copy.next = copy.next != null ? copy.next.next : null;

            original = original.next;
            copy = copy.next;
        }

        return temp;
    }
}

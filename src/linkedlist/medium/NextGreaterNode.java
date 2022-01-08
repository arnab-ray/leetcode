package linkedlist.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author arnab.ray
 * @created on 08/01/22
 */
// #1019
public class NextGreaterNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nodeVals = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            nodeVals.add(temp.val);
            temp = temp.next;
        }

        int[] result = new int[nodeVals.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nodeVals.size(); i++) {
            while (!stack.isEmpty() && nodeVals.get(stack.peek()) < nodeVals.get(i)) {
                result[stack.peek()] = nodeVals.get(i);
                stack.pop();
            }

            stack.push(i);
        }

        return result;
    }
}

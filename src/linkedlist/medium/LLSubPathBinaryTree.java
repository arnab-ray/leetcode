package linkedlist.medium;

/**
 * @author arnab.ray
 * @created on 08/01/22
 */
// #1367
public class LLSubPathBinaryTree {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private boolean isSubPathUtil(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        if (head.val != root.val)
            return false;
        return isSubPathUtil(head.next, root.left) || isSubPathUtil(head.next, root.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;

        return isSubPathUtil(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}

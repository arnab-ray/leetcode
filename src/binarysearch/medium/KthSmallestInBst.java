package binarysearch.medium;

import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestInBst {
    private class TreeNode {
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

    public TreeNode kthSmallestUtil(TreeNode root, AtomicInteger count, int k) {
        if(root == null)
            return null;

        TreeNode left = kthSmallestUtil(root.left, count, k);
        if(left != null)
            return left;

        count.set(count.get() + 1);
        if(count.get() == k)
            return root;

        return kthSmallestUtil(root.right, count, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        AtomicInteger count = new AtomicInteger(0);
        TreeNode node = kthSmallestUtil(root, count, k);
        return node.val;
    }
}

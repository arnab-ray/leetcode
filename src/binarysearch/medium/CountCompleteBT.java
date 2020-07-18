package binarysearch.medium;

import java.util.concurrent.atomic.AtomicInteger;

public class CountCompleteBT {
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

    private void countNodesUtil(TreeNode root, AtomicInteger count) {
        if(root == null)
            return;

        countNodesUtil(root.left, count);
        count.set(count.get() + 1);
        countNodesUtil(root.right, count);
    }

    public int countNodes(TreeNode root) {
        AtomicInteger count = new AtomicInteger(0);
        countNodesUtil(root, count);
        return count.get();
    }
}
